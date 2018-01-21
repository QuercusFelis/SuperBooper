package com.musicalpastries.superboopers.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.musicalpastries.superboopers.SuperBoopers;

/**
 * Andrew Groeling - 12/23/2017.
 */

public class MenuScreen implements Screen {

    private SuperBoopers game;
    private Stage stage;
    private Table table;

    public MenuScreen(SuperBoopers game){
        this.game = game;
        table = new Table();
        //input processing for UI
        stage = new Stage(new ExtendViewport(SuperBoopers.V_WIDTH, SuperBoopers.V_HEIGHT));
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
        table.setFillParent(true);
        table.setDebug(false);
        stage.addActor(table);

        //temporary
        Skin skin = new Skin(Gdx.files.internal("skin/pixthulhu-ui.json"));

        //buttons
        //Image backImage = new Image("back.png");
        //ImageButton back = new ImageButton(skin);
        Table tableTop = new Table();
        tableTop.setDebug(false);
        TextButton back = new TextButton("<", skin);
        TextButton inventory = new TextButton("Inventory", skin);

        TextButton goals = new TextButton("Goals", skin);
        TextButton store = new TextButton("Store", skin);

        Table tableCommunity = new Table();
        tableCommunity.setDebug(false);
        TextButton community = new TextButton("Community", skin);
        TextButton google = new TextButton("G", skin);

        TextButton settings = new TextButton("Settings", skin);

        TextButton donate = new TextButton("Donate", skin);
        TextButton credits = new TextButton("Credits", skin);

        table.top();

        table.add(settings).fillX().colspan(2).padTop(15);

        table.row().padTop(10);
        table.add(tableTop).colspan(2).fillX();
        tableTop.add(back);
        tableTop.add(inventory).expandX().fillX().padLeft(10);

        table.row().padTop(10);
        table.add(goals).fillX().uniformX();
        table.add(store).fillX().uniformX().padLeft(10);

        table.row().padTop(10);
        table.add(tableCommunity).colspan(2).fillX();
        tableCommunity.add(community).expandX().fillX();
        tableCommunity.add(google).padLeft(10).width(100);

        table.row().padTop(10);
        table.add(settings).fillX().colspan(2);

        table.row().padTop(10);
        table.add(donate).fillX().uniformX();
        table.add(credits).fillX().padLeft(10).uniformX();

        //listeners
        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.changeScreen(SuperBoopers.MAIN);
            }
        });
        inventory.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.changeScreen(SuperBoopers.INVENTORY);
            }
        });
//
        goals.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.changeScreen(SuperBoopers.GOALS);
            }
        });
        store.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.changeScreen(SuperBoopers.STORE);
            }
        });
//
        community.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.changeScreen(SuperBoopers.COMMUNITY);
            }
        });
        google.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.changeScreen(SuperBoopers.GOOGLE);
            }
        });
//
        settings.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.changeScreen(SuperBoopers.SETTINGS);
            }
        });
//
        donate.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.changeScreen(SuperBoopers.DONATE);
            }
        });
        credits.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                game.changeScreen(SuperBoopers.CREDITS);
            }
        });
    }


    public void update(){
        table.setFillParent(true);
    }

    @Override
    public void render(float delta) {
    //    dt += Gdx.graphics.getDeltaTime();
        //clear screen
        Gdx.gl.glClearColor(0,.5f,0.2f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1/30f));

        update();
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