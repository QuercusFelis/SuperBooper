package com.musicalpastries.superboopers.Screens;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.musicalpastries.superboopers.SuperBoopers;

/**
 * woodcat - 12/27/2017.
 */

public class SettingScreen extends SuperScreen {

    private Table tableInner;

    public SettingScreen(SuperBoopers game, SuperBoopers.eScreen lastScreen) {
        super(game, lastScreen);

        r= .2f;
        g= .2f;
        b= .2f;
    }

    @Override
    public void show() {
        super.show();
        tableInner = new Table();

        //table contents
        Label title = new Label("Settings", new Label.LabelStyle(skin.getFont("font"), com.badlogic.gdx.graphics.Color.WHITE));
        title.setFontScale(3f);
        TextButton boop10 = new TextButton("+10 Boopers", skin);
        TextButton item20 = new TextButton("+20 Items", skin);
        TextButton reset = new TextButton("Reset", skin);

        //populating table
        table.add(title).expandX().fillX().left();

        table.row();
        table.add(tableInner).colspan(2).expand().fillX().top();
        tableInner.add(boop10).expandX().fillX().padLeft(10).padRight(10).padTop(10).top();
        tableInner.row();
        tableInner.add(item20).expandX().fillX().padLeft(10).padRight(10).padTop(10).top();

        table.row();
        table.add(reset).colspan(2).fillX().pad(10).center().bottom();

        //listeners
        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                getGame().changeScreen(lastScreen, SuperBoopers.eScreen.SETTINGS);}
        });
        boop10.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                int c = 10;
                while (c > 0) {
                    getGame().setLastScanned(""+(int)(Math.random()*100000));
                    getGame().addBooper();
                    c--;
                }
            }
        });
        item20.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                int c = 20;
                while (c > 0) {
                    getGame().addRandItem();
                    c--;
                }
            }
        });
        reset.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                getGame().getBoopers().clear();
                getGame().getItems().clear();
            }
        });
    }

    @Override
    public void renderBatch() {}

    @Override
    public void update() {}
}

