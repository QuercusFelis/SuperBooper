package com.musicalpastries.superboopers.Actors;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.musicalpastries.superboopers.Screens.GameScreen;
import com.musicalpastries.superboopers.SuperBoopers;


/**
 * woodcat - 10/19/2017.
 */

public abstract class Booper extends Actor {
    //master sprite atlas
    public static final TextureAtlas atlas = new TextureAtlas("sprites.txt");

    //animated sprite variables
    protected String species;
    private TextureRegion region;
    private TextureRegion[] keyFrames;
    private Animation animation;
    private int numframes;
    private int frameSize;

    //used for subclass switch cases
    public enum eID {
        DUCK,
        SLIME,
        PILZ,
        SWITCH,
        BONSAI,
        SPINPHONE,
        PINECONE,
        BOX,
        STEAK,
        TENNIS
    }

    public Booper(GameScreen game, int id){
        setupAnimation(id);
        setupLocation(game);

        addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.testXP();
            }
        });
    }

    abstract void selectBooper(eID eSpec);

    public String getSpecies(){
        return species;
    }

    private void setupAnimation(int id){
        frameSize = 64;
        selectBooper(eID.values()[id]);
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
    }

    private void setupLocation(GameScreen game){
        do{
            setX((float)(Math.random()*SuperBoopers.V_WIDTH));
        }while(getX()+frameSize> SuperBoopers.V_WIDTH);

        do{
            setY((float)(Math.random()*SuperBoopers.V_HEIGHT));
        }while(getY()+frameSize > SuperBoopers.V_HEIGHT - game.getTable().findActor("back").getHeight()||getY() < game.getTable().findActor("scan").getHeight());
    }

    public Animation<TextureRegion> draw(){
        return animation;
    }

}
