package com.musicalpastries.superboopers.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.musicalpastries.superboopers.SuperBoopers;

/**
 * Andrew Groeling - 12/23/2017.
 */

public class MenuScreen extends SuperScreen implements Screen {

    private OrthographicCamera gamecam;

    public MenuScreen(SuperBoopers game){
        this.game = game;


        r= 0;
        g= .5f;
        b= .2f;

        //camera
        gamecam = new OrthographicCamera();
        gamecam.setToOrtho(false, SuperBoopers.V_WIDTH, SuperBoopers.V_HEIGHT);
        stage = new Stage(new ExtendViewport(SuperBoopers.V_WIDTH, SuperBoopers.V_HEIGHT, gamecam));
    }

    @Override
    public void show() {
        super.show();

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

        Label copyright = new Label("(C) 2018", new Label.LabelStyle(skin.getFont("font"), com.badlogic.gdx.graphics.Color.WHITE));

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

        table.row().padTop(10);
        table.add(copyright).colspan(2).bottom();

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

    @Override
    void renderBatch() {
    }

    @Override
    public void update(){
        gamecam.update();
        table.setFillParent(true);
    }
}