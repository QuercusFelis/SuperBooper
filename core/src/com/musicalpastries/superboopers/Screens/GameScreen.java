package com.musicalpastries.superboopers.Screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.musicalpastries.superboopers.Actors.Booper;
import com.musicalpastries.superboopers.Actors.Boopermon;
import com.musicalpastries.superboopers.Actors.ImageAnimated;
import com.musicalpastries.superboopers.SuperBoopers;


/**
 * woodcat - 9/29/2017.
 */

public class GameScreen extends SuperScreen {

    private float fScale;

    private SpriteBatch batch;

    private Table tableTop;
    private Label boops;
    private Label lvlLabel;
    private Dialog booperInfo;

    public GameScreen(SuperBoopers game, SuperBoopers.eScreen lastScreen){
        super(game, lastScreen, new OrthographicCamera());
        fScale = 1f;

        r= .9f;
        g= .9f;
        b= .9f;

        game.setXp(0);
        game.setLvl(1);
    }

    @Override
    public void show() {
        super.show();
        tableTop = new Table();

        for (Booper boop:getGame().getBoopers()) {
            stage.addActor(boop);
        }

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle(
                skin.getDrawable("scrollbar-horizontal"),
                skin.getDrawable("scrollbar-horizontal"),
                skin.getDrawable("scrollbar-horizontal"),
                skin.getFont("subtitle")
        );

        //setting up objects in table
        boops = new Label("Boops: " + String.format("%03d", getGame().getXp()),
                new Label.LabelStyle(skin.getFont("font"), Color.SKY));
        boops.setFontScale(fScale);

        lvlLabel = new Label("Lvl: " + String.format("%01d", getGame().getLvl()),
                new Label.LabelStyle(skin.getFont("font"), Color.CORAL));
        lvlLabel.setFontScale(fScale);

        TextButton inventory = new TextButton("inventory", style);
        TextButton scanButton = new TextButton("SCAN", skin);

        //Table Row 0
        table.add(tableTop).expandX().fillX().padTop(10).top();
            //Inner Table Row 0
        tableTop.add(lvlLabel).expandX().top();
        tableTop.add(boops).expandX().top();
            //Inner Table Row 1
        tableTop.row();
        tableTop.add(inventory).colspan(2).fill().padTop(10).top();
        //Table Row 1
        table.row();
        table.add(scanButton).expand().fillX().bottom().colspan(3);

        //adding listeners for all the buttons
        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                getGame().changeScreen(lastScreen, SuperBoopers.eScreen.MAIN);}
        });
        scanButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                getGame().scan();
                incrementBoops();
            }
        });
        inventory.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                getGame().changeScreen(SuperBoopers.eScreen.INVENTORY, SuperBoopers.eScreen.MAIN);
            }
        });

        //adding click listeners for all the boopers
        for (final Actor actor:stage.getActors()) {
            if(actor instanceof Boopermon)
            actor.addListener(new InputListener() {

                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    incrementBoops();
                    showInfoWindow((Boopermon) actor);
                    return super.touchDown(event, x, y, pointer, button);
                }
            });
        }
    }

    public void showInfoWindow(final Boopermon booper){
        booperInfo = new Dialog("Booper Info", skin);

        //ImageAnimated animated = new ImageAnimated(booper.draw());
        booperInfo.getContentTable().add(new Image(booper.draw().getKeyFrames()[0])).padTop(10);
        booperInfo.getContentTable().add(booper.getName()).padTop(10);
        booperInfo.getContentTable().add("lvl: "+booper.getLvl()).padTop(10);
        booperInfo.getContentTable().row();
        booperInfo.getContentTable().add(""+booper.getCreated()).colspan(2);
        booperInfo.button("close");
        booperInfo.show(stage);
    }

    public GameScreen getContext(){
        return this;
    }

    public Label getLvlLabel(){
        return lvlLabel;
    }

    public Table getTable(){
        table.validate();
        return table;
    }

    public void incrementBoops(){
        getGame().incrementXP();
        boops.setText("Boops: " + String.format("%03d", getGame().getXp()));
    }

    @Override
    public void update() {
        getGameCam().update();
    }

    @Override
    public void renderBatch() {
        this.batch = getGame().getBatch();
        batch.begin();
        batch.setProjectionMatrix(getGameCam().combined);
        for (Booper booper:getGame().getBoopers()) {
            batch.setColor(booper.getColor());
            batch.draw(booper.draw().getKeyFrame(dt, true), booper.getX(), booper.getY());
            booper.move(this);
        }
        batch.end();
    }

    @Override
    public void dispose(){
        getGame().getBatch().dispose();
    }

}
