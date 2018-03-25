package com.musicalpastries.superboopers.Actors;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.musicalpastries.superboopers.Screens.GameScreen;
import com.musicalpastries.superboopers.SuperBoopers;

import java.util.logging.Logger;

/**
 * Andrew Groeling - 10/19/2017.
 */

public class Booper extends Actor {
    private static Texture atlas = new Texture("Atlas.png");

    final private GameScreen game;
    private TextureRegion region;
    private int numframes;
    private int frameSize;


    public Booper(GameScreen game, int numframes, int atlasX, int atlasY){
        this.game = game;
        frameSize = 64;
        this.numframes = numframes;
        region = new TextureRegion(atlas, atlasX, atlasY, frameSize, frameSize);

        setX((float)(Math.random()*SuperBoopers.V_WIDTH));
        setY((float)(Math.random()*SuperBoopers.V_HEIGHT));
        addListener(new ClickListener(){

        });

        setColor(new Color((float)(Math.random()-.5), (float)(Math.random()), (float)(Math.random()), 1));
    }

    public Booper(final GameScreen game, int numframes, int atlasX, int atlasY, int frameSize){
        this.game = game;

        this.frameSize = frameSize;
        this.numframes = numframes;
        region = new TextureRegion(atlas, atlasX, atlasY, frameSize, frameSize);

        setX((float)(Math.random()*SuperBoopers.V_WIDTH));
        setY((float)(Math.random()*SuperBoopers.V_HEIGHT));
        addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                game.testXP();
                return true;
            }
        });

        setColor(new Color((float)(Math.random()-.5), (float)(Math.random()), (float)(Math.random()), 1));
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

}
