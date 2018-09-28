package com.musicalpastries.superboopers.Screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.musicalpastries.superboopers.SuperBoopers;

/**
 * Andrew Groeling - 12/27/2017.
 */

public class StoreScreen extends SuperScreen {

    public StoreScreen(SuperBoopers game) {
        super(game);

        r= .3f;
        g= .9f;
        b= .3f;
    }

    @Override
    public void show() {
        super.show();

        //buttons
        //Image backImage = new Image("back.png");
        //ImageButton back = new ImageButton(skin);
        TextButton back = new TextButton("<", skin);
        Label title = new Label("Store", new Label.LabelStyle(skin.getFont("font"), Color.WHITE));
        title.setFontScale(4f);
        //Label credits = new Label("Everything: Andrew Groeling", new Label.LabelStyle(skin.getFont("font"), Color.WHITE));
        //credits.setFontScale(1.4f);

        table.add(back).pad(10);
        table.add(title).expandX().fillX();

        table.row();
        //table.add(credits).colspan(2).expand().fillX().pad(10,20,20,20).top();

        //listeners
        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                getGame().changeScreen(SuperBoopers.MENU);}
        });
    }

    @Override
    void renderBatch() {}

    @Override
    public void update() {}
}

