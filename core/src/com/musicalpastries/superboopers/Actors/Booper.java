package com.musicalpastries.superboopers.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.musicalpastries.superboopers.SuperBoopers;

import java.util.logging.Logger;

/**
 * Andrew Groeling - 10/19/2017.
 */

public class Booper {
    private static Texture atlas = new Texture("Atlas.png");

    private TextureRegion region;
    private int numframes;
    private int frameSize;

    private int xPos;
    private int yPos;

    private Color color;

    public Booper(int numframes, int atlasX, int atlasY){
        frameSize = 64;
        this.numframes = numframes;
        region = new TextureRegion(atlas, atlasX, atlasY, frameSize, frameSize);

        xPos = (int)(Math.random()*SuperBoopers.V_WIDTH);
        yPos = (int)(Math.random()*SuperBoopers.V_HEIGHT);

        color = new Color((float)(Math.random()-.5), (float)(Math.random()), (float)(Math.random()), 1);
    }

    public Booper(int numframes, int atlasX, int atlasY, int frameSize){
        this.numframes = numframes;
        this.frameSize = frameSize;
        region = new TextureRegion(atlas, atlasX, atlasY, frameSize, frameSize);

        xPos = (int)(Math.random()*Gdx.app.getGraphics().getWidth());
        yPos = (int)(Math.random()*Gdx.app.getGraphics().getHeight());

    }

    public Animation<TextureRegion> draw(){
        Animation animation;
        TextureRegion[] keyFrames = new TextureRegion[numframes];
        for (int i = 0; i < numframes; i++) {
            keyFrames[i] = new TextureRegion(region,frameSize*i,0,frameSize,frameSize);
        }
        animation = new Animation(1f/4f, keyFrames);
        return animation;
    }

    public Color getColor(){
        return color;
    }

    public float getXPos() {
        return xPos;
    }

    public float getYPos(){
        return yPos;
    }
}
