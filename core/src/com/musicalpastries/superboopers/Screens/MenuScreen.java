package com.musicalpastries.superboopers.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.musicalpastries.superboopers.SuperBoopers;

import java.util.ArrayList;

import static com.badlogic.gdx.scenes.scene2d.InputEvent.Type.exit;

/**
 * Created by loads on 12/23/2017.
 */

public class MenuScreen implements Screen {

    private SuperBoopers game;
 //   private ArrayList<Actor> actors;
    private Viewport viewport;
    private float dt;
    private Stage stage;
    private ArrayList<com.musicalpastries.superboopers.Actors.Actor> actors;

    public MenuScreen(SuperBoopers game){
        this.game = game;
        //input processing for UI
        stage = new Stage(new ExtendViewport(SuperBoopers.V_WIDTH, SuperBoopers.V_HEIGHT));
        Gdx.input.setInputProcessor(stage);
        actors = new ArrayList<com.musicalpastries.superboopers.Actors.Actor>();
        viewport = new ExtendViewport(SuperBoopers.V_WIDTH, SuperBoopers.V_HEIGHT);
        actors.add(new com.musicalpastries.superboopers.Actors.Actor(4, 0, 0));

    }

    @Override
    public void show() {
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        stage.addActor(table);

        //temporary
        Skin skin = new Skin(Gdx.files.internal("skin/pixthulhu-ui.json"));

        //buttons
        TextButton back = new TextButton("Return", skin);
        TextButton settings = new TextButton("Settings", skin);
        TextButton credits = new TextButton("Credits", skin);

        table.add(back).fillX().uniformX();
        table.row().pad(15,0,15,0);
        table.add(settings).fillX().uniformX();
        table.row();
        table.add(credits).fillX().uniformX();

        //listeners
        //exit
    }


    public void update(){
    }

    @Override
    public void render(float delta) {
        dt += Gdx.graphics.getDeltaTime();
        //clear screen
        Gdx.gl.glClearColor(0,.5f,0.2f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update();

        //drawing
       // hud.stage.draw();
        game.batch.begin();
        for (int i = 0; i < actors.size(); i++) {
            game.batch.draw(actors.get(i).draw().getKeyFrame(dt, true),0,0);
        }
        game.batch.end();
    }


    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, false);
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