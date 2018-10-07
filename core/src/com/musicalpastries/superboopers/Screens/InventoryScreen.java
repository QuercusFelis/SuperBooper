package com.musicalpastries.superboopers.Screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.musicalpastries.superboopers.SuperBoopers;

/**
 * Andrew Groeling - 12/27/2017.
 */

public class InventoryScreen extends SuperScreen {

    private Table items;

    public InventoryScreen(SuperBoopers game, SuperBoopers.eScreen lastScreen) {
        super(game, lastScreen);

        r= .7f;
        g= .6f;
        b= .3f;
    }

    @Override
    public void show() {
        super.show();
        items = new Table();

        //buttons
        Label title = new Label("Inventory", new Label.LabelStyle(skin.getFont("font"), Color.WHITE));
        title.setFontScale(2.5f);

        table.add(title).expandX().fillX().left();

        table.row();
        table.add(items).expand().fill().colspan(2);

        //listeners
        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                getGame().changeScreen(lastScreen, SuperBoopers.eScreen.MENU);}
        });

    }

    @Override
    public void renderBatch() {}

    @Override
    public void update() {}
}