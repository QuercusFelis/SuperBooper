package com.musicalpastries.superboopers.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.musicalpastries.superboopers.SuperBoopers;

/**
 * Created by loads on 12/23/2017.
 */

public class MenuScreen implements Screen {

    private SuperBoopers game;
 //   private ArrayList<Actor> actors;
    private OrthographicCamera gamecam;
    private Viewport viewport;
    private float dt;

    public MenuScreen(SuperBoopers game){
        this.game = game;
//        actors = new ArrayList<Actor>();
        gamecam = new OrthographicCamera();
        gamecam.setToOrtho(false, SuperBoopers.V_WIDTH, SuperBoopers.V_HEIGHT);
        viewport = new ScreenViewport(gamecam);
    }

    @Override
    public void show() {

    }


    public void update(){
        gamecam.update();
    }

    @Override
    public void render(float delta) {
        dt += Gdx.graphics.getDeltaTime();
        //clear screen
        Gdx.gl.glClearColor(.7f,.5f,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //some stuff that I don't understand but needs to be here
        gamecam.update();
        game.batch.setProjectionMatrix(gamecam.combined);
        //drawing

        game.batch.begin();
/*
        for (int i = 0; i < actors.size(); i++) {
            game.batch.draw(actors.get(i).draw().getKeyFrame(dt, true),0,0);
        }
*/
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        gamecam.update();
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
        game.batch.dispose();
    }
}