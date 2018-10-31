package com.musicalpastries.superboopers.Screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.musicalpastries.superboopers.Actors.Boopers.Booper;
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
        ScrollPane scrollPane = new ScrollPane(items, skin);
        scrollPane.setFadeScrollBars(false);
        //setting up scrollpane of items
        for (Booper b:getGame().getBoopers()) {
            final Image image = new Image(b.draw().getKeyFrame(0));
            //configure listing
            Table listing = new Table(skin);
            items.add(listing).left().expandX().fill().padLeft(5).padRight(5).padBottom(2);
            listing.setDebug(false);
            listing.add(image);
            listing.add("temporary text").expandX().fill().padLeft(50);
            items.row();
            //add listener for item in listing
            listing.addListener(new ActorGestureListener() {
                @Override
                public void tap(InputEvent event, float x, float y, int pointer, int button) {
                    showInfoWindow(new Image(image.getDrawable())); }});
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

    private void showInfoWindow(Image image){
        itemInfo = new Dialog("Item Info", skin);
        TextButton use = new TextButton("use", skin);

        //dialogue box layout
        itemInfo.getContentTable().add(image).padTop(10);
        itemInfo.getContentTable().add("Size: "+image.getWidth()).padTop(10).bottom().left();
        itemInfo.getContentTable().row();
        itemInfo.getContentTable().add();
        itemInfo.button("close");
        itemInfo.getButtonTable().add(use).padLeft(10);

        //setup listeners for items in box
        use.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

            }
        });

        //dialogue box built, ready to show
        itemInfo.show(stage);
    }

    @Override
    public void renderBatch() {}

    @Override
    public void update() {}
}