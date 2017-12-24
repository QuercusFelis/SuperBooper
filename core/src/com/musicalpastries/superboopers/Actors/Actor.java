package com.musicalpastries.superboopers.Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Andrew Groeling - 10/19/2017.
 */

public class Actor {
    private static Texture atlas = new Texture("Atlas.png");

    private int frames;
    private int frameNumber;
    private int xi;
    private int yi;
    private int frameSize;
    private TextureRegion region;

    public Actor(int frames, int xi, int yi){
        this.frames = frames;
        this.xi = xi;
        this.yi = yi;
        frameNumber = 0;
        frameSize = 64;
        region = new TextureRegion(atlas, xi, yi, frameSize, frameSize);
    }

    public Actor(int frames, int xi, int yi, int frameSize){
        this.frames = frames;
        this.xi = xi;
        this.yi = yi;
        frameNumber = 0;
        this.frameSize = frameSize;
        region = new TextureRegion(atlas, xi, yi, frameSize, frameSize);
    }

    public Animation<TextureRegion> draw(/*SpriteBatch batch*/){
        TextureRegion[] keyFrames = new TextureRegion[frames];
        for (int i = 0; i < frames; i++) {
            keyFrames[i] = new TextureRegion(region,frameSize*i,0,frameSize,frameSize);
        }
        return new Animation(1f/4f, keyFrames);
    }
}
