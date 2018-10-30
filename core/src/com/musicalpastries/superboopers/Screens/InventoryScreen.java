package com.musicalpastries.superboopers.Screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.musicalpastries.superboopers.Actors.Booper;
import com.musicalpastries.superboopers.SuperBoopers;

/**
 * woodcat - 12/27/2017.
 */

public class InventoryScreen extends SuperScreen {

    private Table items;
    private Dialog itemInfo;

    public InventoryScreen(SuperBoopers game, SuperBoopers.eScreen lastScreen) {
        super(game, lastScreen);

        r= .7f;
        g= .6f;
        b= .3f;
    }

    @Override
    public void show() {
        super.show();
        table.setDebug(false);
        //instantiating scene widgets
        Label title = new Label("Inventory", new Label.LabelStyle(skin.getFont("font"), Color.WHITE));
        title.setFontScale(2.5f);

        items = new Table();
        VerticalGroup[] vGroups = new VerticalGroup[SuperBoopers.V_WIDTH/64];
        for (int i = 0; i < vGroups.length; i++) {
            vGroups[i] = new VerticalGroup();
        }
        ScrollPane scrollPane = new ScrollPane(items, skin);
        //setting up scrollpane of items
        for (VerticalGroup g :vGroups) {
            for (Booper b:getGame().getBoopers()) {
                final Image image = new Image(b.draw().getKeyFrame(0));
                g.addActor(image);
                image.addListener(new ActorGestureListener() {
                    @Override
                    public void tap(InputEvent event, float x, float y, int pointer, int button) {
                        showInfoWindow(image);
                    }

                });
            }
            items.add(g).pad(2).top();
        }
        items.setDebug(false);
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

    public void showInfoWindow(Image image){
        itemInfo = new Dialog("Item Info", skin);

        itemInfo.getContentTable().add(image).padTop(10);
        itemInfo.getContentTable().add("width: "+image.getImageWidth()).padTop(10).bottom().left();
        itemInfo.getContentTable().row();
        itemInfo.getContentTable().add();
        itemInfo.getContentTable().add("height: "+image.getImageHeight()).padTop(10);
        itemInfo.button("close");
        itemInfo.show(stage);
    }

    @Override
    public void renderBatch() {}

    @Override
    public void update() {}
}