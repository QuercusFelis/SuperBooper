package com.musicalpastries.superboopers.Screens;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.musicalpastries.superboopers.SuperBoopers;

/**
 * Andrew Groeling - 12/27/2017.
 */

public class CreditsScreen extends SuperScreen {

    public CreditsScreen(SuperBoopers game, SuperBoopers.eScreen lastScreen) {
        super(game, lastScreen);
        r= .3f;
        g= .6f;
        b= .9f;
    }

    @Override
    public void show() {
        super.show();

        //table contents
        Label title = new Label("Credits", new Label.LabelStyle(skin.getFont("font"), com.badlogic.gdx.graphics.Color.WHITE));
        title.setFontScale(4f);

        Label credits = new Label("Everything: Andrew Groeling\n\n" +
                "Button & Font Art: Raymond Buckley" +
                "\n(CC BY 4.0,\n" +
                "https://tinyurl.com/pixthulu)\n\n" +
                "ZXing Barcode Scanning Library by\n" +
                "Google", new Label.LabelStyle(skin.getFont("font"), com.badlogic.gdx.graphics.Color.WHITE));
        credits.setFontScale(1f);

        table.add(title).expandX().fillX();

        table.row();
        table.add(credits).colspan(2).expand().fillX().pad(10,20,20,20).top();

        //listeners

        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                getGame().changeScreen(lastScreen, SuperBoopers.eScreen.CREDITS);}
        });
    }

    @Override
    void renderBatch() {}

    @Override
    public void update() {}
}

