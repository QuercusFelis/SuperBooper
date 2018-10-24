package com.musicalpastries.superboopers.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.musicalpastries.superboopers.Actors.Booper;
import com.musicalpastries.superboopers.SuperBoopers;

/**
 * woodcat - 12/27/2017.
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
        table.setDebug(true);
        //instantiating scene widgets
        Label title = new Label("Inventory", new Label.LabelStyle(skin.getFont("font"), Color.WHITE));
        title.setFontScale(2.5f);

        items = new Table();
        VerticalGroup[] vGroups = new VerticalGroup[Gdx.graphics.getWidth()/64];
        for (int i = 0; i < vGroups.length; i++) {
            vGroups[i] = new VerticalGroup();
        }
        ScrollPane scrollPane = new ScrollPane(items, skin);
        //setting up scrollpane of items
        for (VerticalGroup g :vGroups) {
            for (Booper b:getGame().getBoopers()) {
                g.addActor(new Image(b.draw().getKeyFrame(0)));
            }
            items.add(g).pad(2);
        }
        items.setDebug(true);
        //adding widgets to main scene table
        table.add(title).expandX().fillX().left();

        table.row();
        table.add(scrollPane).expand().fill().colspan(2);

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