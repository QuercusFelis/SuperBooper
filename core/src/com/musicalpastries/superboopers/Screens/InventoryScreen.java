package com.musicalpastries.superboopers.Screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.musicalpastries.superboopers.Actors.Items.Item;
import com.musicalpastries.superboopers.Actors.Items.ListItem;
import com.musicalpastries.superboopers.SuperBoopers;

/**
 * woodcat - 12/27/2017.
 */

public class InventoryScreen extends ListScreen {

    public InventoryScreen(SuperBoopers game, SuperBoopers.eScreen lastScreen) {
        super(game, lastScreen);
        title = new Label("Inventory", new Label.LabelStyle(skin.getFont("font"), Color.WHITE));

        r= .7f;
        g= .6f;
        b= .3f;
    }

    @Override
    public void show() {
        super.show();
        title.setFontScale(2.5f);

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