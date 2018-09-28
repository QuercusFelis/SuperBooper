package com.musicalpastries.superboopers.Actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.musicalpastries.superboopers.Screens.GameScreen;
import com.musicalpastries.superboopers.SuperBoopers;

import static com.musicalpastries.superboopers.Actors.Booper.eSpecies.*;


/**
 * Andrew Groeling - 10/19/2017.
 */

public class Booper extends Actor {

    public static final TextureAtlas atlas = new TextureAtlas("sprites.txt");

    private TextureRegion region;
    private TextureRegion[] keyFrames;
    private Animation animation;

    private String species;

    public enum eSpecies{
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

    private int numframes;
    private int frameSize;


    public Booper(GameScreen game, int id){
        frameSize = 64;
        selectBooper(eSpecies.values()[id]);
        region = atlas.findRegion(species);
        this.numframes = region.getRegionWidth()/frameSize;
        System.out.println(""+numframes);
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

        //TODO: make this onclick listener do stuff
        addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                game.testXP();
                return true;
            }
        });

        setColor(new Color((float)(Math.random()+.3), (float)(Math.random()+.3), (float)(Math.random()+.3), 1));
    }

//TODO: make specific color profiles
    public void selectBooper(eSpecies eSpec){

        switch(eSpec){
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
            case BONSAI:
                species = "bonsai";
                break;
            case SPINPHONE:
                species = "spinPhone";
                break;
            case PINECONE:
                species = "pinecone";
                break;
            case BOX:
                species = "box";
                break;
            case STEAK:
                species = "steak";
                break;
            case TENNIS:
                species = "tennis";
                break;
        }
    }

    public String getSpecies(){
        return species;
    }

    public Animation<TextureRegion> draw(){
        return animation;
    }

}
