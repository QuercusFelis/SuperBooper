package com.musicalpastries.superboopers.Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Andrew Groeling - 10/19/2017.
 */

public class Booper {
    private static Texture atlas = new Texture("Atlas.png");

    private int numframes;
    private int currentFrame;
    private int atlasX;
    private int atlasY;

    private int xPos;
    private int yPos;

    private int frameSize;
    private TextureRegion region;

    public Booper(int numframes, int atlasX, int atlasY){
        this.numframes = numframes;
        this.atlasX = atlasX;
        this.atlasY = atlasY;
        currentFrame = 0;
        frameSize = 64;
        region = new TextureRegion(atlas, atlasX, atlasY, frameSize, frameSize);
    }

    public Booper(int numframes, int atlasX, int atlasY, int frameSize){
        this.numframes = numframes;
        this.atlasX = atlasX;
        this.atlasY = atlasY;
        currentFrame = 0;
        this.frameSize = frameSize;
        region = new TextureRegion(atlas, atlasX, atlasY, frameSize, frameSize);
    }

    public Animation<TextureRegion> draw(/*SpriteBatch batch*/){
        TextureRegion[] keyFrames = new TextureRegion[numframes];
        for (int i = 0; i < numframes; i++) {
            keyFrames[i] = new TextureRegion(region,frameSize*i,0,frameSize,frameSize);
        }
        return new Animation(1f/4f, keyFrames);
    }
}
