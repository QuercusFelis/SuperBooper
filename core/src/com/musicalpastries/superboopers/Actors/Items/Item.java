package com.musicalpastries.superboopers.Actors.Items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.GdxRuntimeException;

/**
 * Created by loads on 10/31/2018.
 */

public class Item extends ListItem{

    public Item(int quantity, String name, String description, String type){
        super(quantity, description, name, "use", type);
        setupGraphics();
    }

    protected void setupGraphics() {
        try{
            setIcon(new Image(new Texture(Gdx.files.internal("back.png"))));
        } catch (GdxRuntimeException e){
            System.err.println("Are you trying to run a desktop instance?");
            setIcon(new Image(new Texture(Gdx.files.internal("AndroidStudioProjects/SuperBooper/android/assets/back.png"))));
        }
    }

    @Override
    protected void setupGraphics(int id, double[] rgb) {

    }
}
