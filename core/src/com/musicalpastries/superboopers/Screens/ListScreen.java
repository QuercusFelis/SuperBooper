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
 * Created by loads on 10/31/2018.
 */

public abstract class ListScreen extends SuperScreen {

    protected Table items;
    protected Dialog itemInfo;
    protected Label title;

    public ListScreen(SuperBoopers game, SuperBoopers.eScreen lastScreen) {
        super(game, lastScreen);
    }

    @Override
    public void show() {
        super.show();
        table.setDebug(false);


        //instantiating scene widgets
        items = new Table();
        ScrollPane scrollPane = new ScrollPane(items, skin);
        scrollPane.setFadeScrollBars(false);
        //setting up scrollpane of items
        if(getGame().getItems() != null)
            for (final Item i:getGame().getItems()) {
                //configure listing
                Table listing = new Table(skin);
                items.add(listing).left().expandX().fill().padLeft(5).padRight(5).padBottom(2);
                listing.setDebug(false);
                listing.add(i.getIcon());
                listing.add(i.getName()).expandX().fill().padLeft(50);
                items.row();
                //add listener for item in listing
                listing.addListener(new ActorGestureListener() {
                    @Override
                    public void tap(InputEvent event, float x, float y, int pointer, int button) {
                        showInfoWindow(i); }});
            }
        items.setDebug(false);
        //adding widgets to main scene table
        table.add(title).expandX().fillX().left();

        table.row();
        table.add(scrollPane).expand().fill().colspan(2);
    }

    private void showInfoWindow(ListItem listItem){
        itemInfo = new Dialog(listItem.getType(), skin);
        TextButton interact = new TextButton(listItem.getInteractText(), skin);

        //dialogue box layout
        itemInfo.getContentTable().add(listItem.getIconCopy()).padTop(10);
        itemInfo.getContentTable().add(listItem.getName()).padTop(10).bottom().left();
        itemInfo.getContentTable().row();
        //itemInfo.getContentTable().add(ListItem.getDescription());
        itemInfo.button("close");
        itemInfo.getButtonTable().add(interact).padLeft(10);

        //setup listeners for items in box
        //interact.addListener(listItem.getChangeListener());

        //dialogue box built, ready to show
        itemInfo.show(stage);
    }
}
