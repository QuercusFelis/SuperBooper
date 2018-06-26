package com.musicalpastries.superboopers.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.musicalpastries.superboopers.Actors.Booper;
import com.musicalpastries.superboopers.SuperBoopers;

/**
 * Andrew Groeling - 12/27/2017.
 */

public class SettingScreen extends SuperScreen implements Screen {

    public SettingScreen(SuperBoopers game) {
        this.game = game;

        r= .2f;
        g= .2f;
        b= .2f;

        //input processing for UI
        stage = new Stage(new ExtendViewport(SuperBoopers.V_WIDTH, SuperBoopers.V_HEIGHT));

    }

    @Override
    public void show() {
        //table initialization
        Gdx.input.setInputProcessor(stage);
        Table table = new Table();
        if (stage.getActors().size == 0) {
            stage.addActor(table);}
        table.setFillParent(true);
        table.top();

        Skin skin = new Skin(Gdx.files.internal("skin/pixthulhu-ui.json"));

        //table contents
        TextButton back = new TextButton("<", skin);

        Label title = new Label("Settings", new Label.LabelStyle(skin.getFont("font"), com.badlogic.gdx.graphics.Color.WHITE));
        title.setFontScale(3f);

        TextButton boop10 = new TextButton("+10 Boopers", skin);

        //populating table
        table.add(back).pad(10).left();
        table.add(title).expandX().fillX().left();

        table.row();
        table.add(boop10).colspan(2).expand().pad(10).left().top();

        //listeners
        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.changeScreen(SuperBoopers.MENU);
            }
        });
        boop10.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                int c = 10;
                while (c > 0) {
                    game.addBoopers(new Booper(game.getGameScreen(), (int) (Math.random() * Booper.atlas.getRegions().size)));
                    c--;
                }
            }
        });
    }

    @Override
    public void renderBatch() {}

    @Override
    public void update() {}
}

