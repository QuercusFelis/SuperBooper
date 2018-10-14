package com.musicalpastries.superboopers.Screens;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.musicalpastries.superboopers.Actors.Booper;
import com.musicalpastries.superboopers.Actors.Boopermon;
import com.musicalpastries.superboopers.SuperBoopers;

/**
 * Andrew Groeling - 12/27/2017.
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
        TextButton reset = new TextButton("Reset", skin);

        //populating table
        table.add(title).expandX().fillX().left();

        table.row();
        table.add(tableInner).colspan(2).expand().fill();
        tableInner.add(boop10).colspan(2).expand().fillX().pad(10).center().top();

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
                    getGame().addBoopers(new Boopermon(getGame().getGameScreen(), (int) (Math.random() * Booper.atlas.getRegions().size)));
                    c--;
                }
            }
        });
        reset.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                getGame().getBoopers().clear();
            }
        });
    }

    @Override
    public void renderBatch() {}

    @Override
    public void update() {}
}

