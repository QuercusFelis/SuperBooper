package com.musicalpastries.superboopers.Actors.Items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.GdxRuntimeException;

/**
 * Created by woodcat on 10/31/2018.
 */

public class Item extends ListItem{

    public Item(int quantity, String name, String description, String type){
        super(quantity, description, name, "use", type);
    }

    /*@Override
    protected void setupGraphics(int id, double[] rgb) {
        //TODO:
    }*/
}
