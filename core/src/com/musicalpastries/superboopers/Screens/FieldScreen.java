package com.musicalpastries.superboopers.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.musicalpastries.superboopers.Actors.Actor;
import com.musicalpastries.superboopers.Scenes.Hud;
import com.musicalpastries.superboopers.SuperBoopers;

import java.util.ArrayList;

/**
 * Created by Andrew Groeling on 9/29/2017.
 */

public class FieldScreen implements Screen {

    private SuperBoopers game;
    private ArrayList<Actor> actors;
    private Camera gamecam;
    private Viewport viewport;
    private Hud hud;

    public FieldScreen(SuperBoopers game){
        this.game = game;
        actors = new ArrayList<Actor>();
        gamecam = new OrthographicCamera();
        viewport = new FitViewport(SuperBoopers.V_WIDTH, SuperBoopers.V_HEIGHT, gamecam);
        hud = new Hud(game.batch);
        actors.add(new Actor(4, 0, 0));
    }

    @Override
    public void show() {

    }


    public void update(){
        for (int i = 0; i < actors.size(); i++) {
            actors.get(i).update();
        }
        gamecam.update();
    }

    @Override
    public void render(float delta) {
        //clear screen
        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();

        game.batch.begin();
        for (int i = 0; i < actors.size(); i++) {
            actors.get(i).draw(game.batch);
        }
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
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
