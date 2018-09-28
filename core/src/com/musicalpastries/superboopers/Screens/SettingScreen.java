package com.musicalpastries.superboopers.Screens;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.musicalpastries.superboopers.Actors.Booper;
import com.musicalpastries.superboopers.SuperBoopers;

/**
 * Andrew Groeling - 12/27/2017.
 */

public class SettingScreen extends SuperScreen {

    public SettingScreen(SuperBoopers game) {
        super(game);

        r= .2f;
        g= .2f;
        b= .2f;
    }

    @Override
    public void show() {
        super.show();

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
                getGame().changeScreen(SuperBoopers.MENU);
            }
        });
        boop10.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                int c = 10;
                while (c > 0) {
                    getGame().addBoopers(new Booper(getGame().getGameScreen(), (int) (Math.random() * Booper.atlas.getRegions().size)));
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

