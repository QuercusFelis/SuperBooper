package com.musicalpastries.superboopers.Actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
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

    public static final TextureAtlas atlas = new TextureAtlas("sprites.txt");

    private GameScreen game;
    private TextureRegion region;
    private TextureRegion[] keyFrames;
    private Animation animation;

    private String species;

    public static final int DUCK = 0;
    public static final int SLIME = 1;
    public static final int PILZ = 2;
    public static final int SWITCH = 3;

    private int numframes;
    private int frameSize;


    public Booper(GameScreen game, int id){
        this.game = game;
        frameSize = 64;
        selectBooper(id);
        region = atlas.findRegion(species);
        this.numframes = region.getRegionWidth()/frameSize;
        keyFrames = new TextureRegion[numframes];

        int c=0;
        for (int i = (int)(Math.random()*numframes); c < numframes; i++) {
            if(i == numframes)i=0;
            keyFrames[c] = new TextureRegion(region,frameSize*i,0, frameSize, frameSize);
            c++;
        }
        animation = new Animation(1f/numframes, keyFrames);

        do{
            setX((float)(Math.random()*SuperBoopers.V_WIDTH));
        }while(getX()+frameSize> SuperBoopers.V_WIDTH);

        do{
            setY((float)(Math.random()*SuperBoopers.V_HEIGHT));
        }while(getY()+frameSize > SuperBoopers.V_HEIGHT - game.getTable().findActor("back").getHeight()||getY() < game.getTable().findActor("scan").getHeight());

        addListener(new ClickListener(){

        });

        setColor(new Color((float)(Math.random()+.3), (float)(Math.random()+.3), (float)(Math.random()+.3), 1));
    }

    public Booper(final GameScreen game, String name, int frameSize){
        this.game = game;
        this.frameSize = frameSize;
        region = atlas.findRegion(name);
        this.numframes = region.getRegionWidth()/frameSize;
        keyFrames = new TextureRegion[numframes];

        for (int i = 0; i < numframes; i++) {
            keyFrames[i] = new TextureRegion(region,frameSize*i,0, frameSize, frameSize);
        }
        animation = new Animation(1f/numframes, keyFrames);


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

    public void selectBooper(int id){
        switch(id){
            case DUCK:
                species = "duck";
                break;
            case SLIME:
                species = "slime";
                break;
            case PILZ:
                species = "pilz";
                break;
            case SWITCH:
                species = "switch";
                break;
        }
    }

    public Animation<TextureRegion> draw(){
        return animation;
    }

}
