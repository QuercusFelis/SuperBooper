package com.musicalpastries.superboopers.Actors.Items;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class Goal extends ListItem {

    public Goal(int num, String name, String description, String type) {
        super(num, name, description, "remind", type);
    }

    /*@Override
    protected void setupGraphics(int id, double[] rgb) {
        //TODO:
    }*/
}
