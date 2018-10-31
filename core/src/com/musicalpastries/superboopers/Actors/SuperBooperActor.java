package com.musicalpastries.superboopers.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.GdxRuntimeException;

public abstract class SuperBooperActor extends Actor {
    protected static final int FRAME_SIZE = 64;

    protected static TextureAtlas atlas;
    private static boolean atlasSet = false;
    protected TextureRegion region;
    private TextureRegion[] keyFrames;
    private Animation animation;
    private int numframes;

    public SuperBooperActor(){}

    public SuperBooperActor(int id, double[] rgb) {
        setupGraphics(id, rgb);
    }

    public Animation<TextureRegion> draw(){
        return animation;
    }

    abstract protected void setupGraphics(int id, double[] rgb);

    protected void setupAnimation(){
        numframes = region.getRegionWidth() / FRAME_SIZE;
        keyFrames = new TextureRegion[numframes];
        int c=0;
        for (int i = (int)(Math.random()*numframes); c < numframes; i++) {
            if(i == numframes)i=0;
            keyFrames[c] = new TextureRegion(region, FRAME_SIZE *i,0, FRAME_SIZE, FRAME_SIZE);
            c++;
        }
        animation = new Animation(1f/numframes, keyFrames);
        setSize(FRAME_SIZE, FRAME_SIZE);
    }

    protected static void setAtlas(String pathInternal, String pathPC)throws GdxRuntimeException{
        if(!atlasSet){
            try{
                atlas = new TextureAtlas(Gdx.files.internal(pathInternal));
            } catch (GdxRuntimeException e){
                System.err.println("Are you trying to run a desktop instance?");
                atlas = new TextureAtlas(Gdx.files.external(pathPC));
            }
        }
    }
}
