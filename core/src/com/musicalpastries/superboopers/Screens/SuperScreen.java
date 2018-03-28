package com.musicalpastries.superboopers.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.musicalpastries.superboopers.SuperBoopers;

/**
 * Andrew Groeling - 3/25/2018.
 */

public abstract class SuperScreen implements Screen {
    public SuperBoopers game;
    public Stage stage;
    public float dt;

    public float r;
    public float g;
    public float b;

    abstract void renderBatch();

    abstract void update();

    @Override
    public void render(float delta) {
        dt += Gdx.graphics.getDeltaTime();
        //clear screen
        Gdx.gl.glClearColor(r, g, b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));

        update();

        //drawing
        renderBatch();
        stage.draw();
    }


    @Override
    public void resize(int width, int height) {
        /*System.out.println("Width: "+Gdx.graphics.getWidth());
        System.out.println("Height: "+Gdx.graphics.getHeight());*/
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
        game.batch.dispose();
    }
}