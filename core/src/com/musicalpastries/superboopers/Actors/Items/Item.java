package com.musicalpastries.superboopers.Actors.Items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.GdxRuntimeException;

/**
 * woodcat - 10/14/2018.
 */
public abstract class Item extends Actor {
    //master sprite atlas
    public static TextureAtlas atlas;
    private static boolean atlasSet = false;

    private TextureRegion region;
    public static final int SIZE = 64;

    public static void setAtlas() {
        //TODO: make textures for items and put texture atlas in file system
        /*if(!atlasSet){
            try{
                atlas = new TextureAtlas(Gdx.files.internal("sprites.txt"));
            } catch (GdxRuntimeException e){
                System.err.println("Are you trying to run a desktop instance?");
                atlas = new TextureAtlas(Gdx.files.external("AndroidStudioProjects\\SuperBooper\\android\\assets\\sprites.txt"));
            }
        }*/
    }

}
