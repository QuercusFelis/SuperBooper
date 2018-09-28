package com.musicalpastries.superboopers.Screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.musicalpastries.superboopers.SuperBoopers;

/**
 * Andrew Groeling - 12/27/2017.
 */

public class GoalScreen extends SuperScreen {

    public GoalScreen(SuperBoopers game) {
        super(game);
        r= .7f;
        g= .6f;
        b= .3f;
    }

    @Override
    public void show() {
        super.show();

        //buttons
        Label title = new Label("Goals", new Label.LabelStyle(skin.getFont("font"), Color.WHITE));
        title.setFontScale(4f);

        table.add(title).expandX().fillX();

        table.row();
        //listeners
    }

    @Override
    void renderBatch() {}

    @Override
    public void update() {}
}

