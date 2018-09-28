package com.musicalpastries.superboopers.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.SerializationException;
import com.musicalpastries.superboopers.SuperBoopers;

import java.io.FileNotFoundException;

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

    public Skin skin;

    public SuperScreen(){
        setSkin();
    }

    abstract void renderBatch();

    abstract void update();

    public void setSkin() throws SerializationException{
        try{
             skin = new Skin(Gdx.files.internal("skin/pixthulhu-ui.json"));
        } catch (SerializationException e){
            System.err.println("Are you trying to run a desktop instance?");
            skin = new Skin(Gdx.files.internal("C:\\Users\\loads\\AndroidStudioProjects\\SuperBooper\\desktop\\skin\\pixthulhu-ui.json"));
        }
    }

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
