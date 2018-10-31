package com.musicalpastries.superboopers.Actors.Items;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.musicalpastries.superboopers.Actors.SuperBooperActor;

/**
 * woodcat - 10/14/2018.
 */
public abstract class Item extends SuperBooperActor {
    //master sprite atlas
    public static TextureAtlas atlas;
    private static boolean atlasSet = false;
    public static final int SIZE = 64;

    private int quantity;
    private String description;
    private String name;

    public static void setAtlas() {
        //setAtlas(items.txt, "AndroidStudioProjects/SuperBooper/android/assets/items.txt");
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return name;
    }


}
