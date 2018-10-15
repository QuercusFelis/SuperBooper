package com.musicalpastries.superboopers.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.SerializationException;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.musicalpastries.superboopers.SuperBoopers;

/**
 * woodcat - 3/25/2018.
 */

public abstract class SuperScreen implements Screen {
    private SuperBoopers game;
    protected SuperBoopers.eScreen lastScreen;

    protected Stage stage;
    private OrthographicCamera gameCam;
    protected TextButton back;

    protected float dt;

    protected float r;
    protected float g;
    protected float b;

    protected static Skin skin;
    protected Table table;

    public SuperScreen(SuperBoopers game, SuperBoopers.eScreen lastScreen){
        this.game = game;
        this.lastScreen = lastScreen;

        //input processing for UI
        stage = new Stage(new ExtendViewport(SuperBoopers.V_WIDTH, SuperBoopers.V_HEIGHT));
        setSkin();
    }

    public SuperScreen(SuperBoopers game, SuperBoopers.eScreen lastScreen, OrthographicCamera gameCam){
        this.game = game;
        this.gameCam = gameCam;
        this.lastScreen = lastScreen;

        //input processing for UI
        this.gameCam.setToOrtho(false, SuperBoopers.V_WIDTH, SuperBoopers.V_HEIGHT);
        this.stage = new Stage(new ExtendViewport(SuperBoopers.V_WIDTH, SuperBoopers.V_HEIGHT, this.gameCam));
        setSkin();
    }

    abstract void renderBatch();

    abstract void update();

    private void setSkin() throws SerializationException{
        try{
             skin = new Skin(Gdx.files.internal("skin/pixthulhu-ui.json"));
        } catch (SerializationException e){
            System.err.println("Are you trying to run a desktop instance?");
            skin = new Skin(Gdx.files.external("AndroidStudioProjects\\SuperBooper\\android\\assets\\skin\\pixthulhu-ui.json"));
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

    public SuperBoopers getGame() {
        return game;
    }

    public OrthographicCamera getGameCam(){
        return gameCam;
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
    public void show() {
        Gdx.input.setInputProcessor(stage);
        table = new Table();
        if(stage.getActors().size ==0){
            stage.addActor(table);
        }
        table.setFillParent(true);
        table.setDebug(false);
        table.top();
        System.out.println(table.toString());

        setSkin();
        back = new TextButton("<", skin);

        if(!(this instanceof MenuScreen)) table.add(back).pad(10).left();
    }

    public void setLastScreen(SuperBoopers.eScreen lastScreen) {
        this.lastScreen = lastScreen;
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
        game.getBatch().dispose();
    }
}
