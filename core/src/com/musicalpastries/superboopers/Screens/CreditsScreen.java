package com.musicalpastries.superboopers.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.musicalpastries.superboopers.SuperBoopers;

import java.awt.Color;

/**
 * Andrew Groeling - 12/27/2017.
 */

public class CreditsScreen implements Screen {

    private SuperBoopers game;
    private Stage stage;

    public CreditsScreen(SuperBoopers game) {
        this.game = game;
        //input processing for UI
        stage = new Stage(new ExtendViewport(SuperBoopers.V_WIDTH, SuperBoopers.V_HEIGHT));
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
        Table table = new Table();
        table.setFillParent(true);
        table.top();
        stage.addActor(table);

        //temporary
        Skin skin = new Skin(Gdx.files.internal("skin/pixthulhu-ui.json"));

        //buttons
        //Image backImage = new Image("back.png");
        //ImageButton back = new ImageButton(skin);
        TextButton back = new TextButton("<", skin);
        Label title = new Label("Credits", new Label.LabelStyle(new BitmapFont(), com.badlogic.gdx.graphics.Color.WHITE));
        title.setFontScale(5f);
        Label credits = new Label("Everything: Andrew Groeling", new Label.LabelStyle(new BitmapFont(), com.badlogic.gdx.graphics.Color.WHITE));
        credits.setFontScale(1.4f);

        table.add(back).pad(10);
        table.add(title).expandX().fillX();

        table.row();
        table.add(credits).colspan(2).expand().fillX().pad(10,20,20,20).top();

        //listeners
        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.changeScreen(SuperBoopers.MENU);}
        });
    }

    public void update() {
        }

    @Override
    public void render(float delta) {
        //    dt += Gdx.graphics.getDeltaTime();
        //clear screen
        Gdx.gl.glClearColor(.3f, .6f, .9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
         stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));

        //drawing
        stage.draw();
        /*game.batch.begin();
        game.batch.end();*/
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

