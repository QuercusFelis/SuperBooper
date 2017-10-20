package com.musicalpastries.superboopers.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.musicalpastries.superboopers.Actors.Actor;
import com.musicalpastries.superboopers.Scenes.Hud;
import com.musicalpastries.superboopers.SuperBoopers;

/**
 * Created by Andrew Groeling on 9/29/2017.
 */

public class FieldScreen implements Screen {

    private SuperBoopers game;
    private Actor slimeActor;
    private OrthographicCamera gamecam;
    private Viewport viewport;
    private Hud hud;

    public FieldScreen(SuperBoopers game){
        this.game = game;
        slimeActor = new Actor(4, 0, 0);
        gamecam = new OrthographicCamera();
        viewport = new FitViewport(SuperBoopers.V_WIDTH, SuperBoopers.V_HEIGHT, gamecam);
        hud = new Hud(game.batch);
    }

    @Override
    public void show() {

    }

    public void handleInput(float dt){
        if (Gdx.input.isTouched()){
            gamecam.position.x += 100*dt;
        }
    }

    public void update(float dt){
        handleInput(dt);
        slimeActor.update();
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
        slimeActor.draw(game.batch);
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
