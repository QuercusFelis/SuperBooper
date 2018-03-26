package com.musicalpastries.superboopers.Screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.musicalpastries.superboopers.SuperBoopers;

/**
 * Andrew Groeling - 3/25/2018.
 */

public abstract class SuperScreen implements Screen {
    public SuperBoopers game;
    public Stage stage;


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
