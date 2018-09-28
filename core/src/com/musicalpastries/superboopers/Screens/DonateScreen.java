package com.musicalpastries.superboopers.Screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.musicalpastries.superboopers.SuperBoopers;

/**
 * Andrew Groeling - 1/20/2018.
 */

public class DonateScreen extends SuperScreen {

    public DonateScreen(SuperBoopers game) {
        super(game);

        r= (float)(Math.random());
        g= (float)(Math.random());
        b= (float)(Math.random());
    }

    @Override
    public void show() {
        super.show();

        //buttons
        Label title = new Label("Donate", new Label.LabelStyle(skin.getFont("font"), Color.WHITE));
        title.setFontScale(4f);
        Label credits = new Label("Pls donate thx bye", new Label.LabelStyle(skin.getFont("font"), Color.WHITE));
        credits.setFontScale(1.4f);

        table.add(title).expandX().fillX();

        table.row();
        table.add(credits).colspan(2).expand().fillX().pad(10,20,20,20).top();

        //listeners
    }

    @Override
    public void renderBatch() {}

    @Override
    public void update() {}

}

