package com.musicalpastries.superboopers.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.musicalpastries.superboopers.Screens.GameScreen;
import com.musicalpastries.superboopers.SuperBoopers;


/**
 * woodcat - 10/19/2017.
 */

public abstract class Booper extends Actor {
    //master sprite atlas
    public static TextureAtlas atlas;
    protected static boolean atlasSet = false;

    GameScreen game;

    //animated sprite variables
    protected String species;
    private TextureRegion region;
    private TextureRegion[] keyFrames;
    private Animation animation;
    private int numframes;
    public static final int FRAME_SIZE = 64;

    protected eID id;

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

        addListener(new InputListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button){
                super.touchUp(event, x, y, pointer, button);

            }
        });
    }

    public static void setAtlas()throws GdxRuntimeException{
        if(!atlasSet){
            try{
                atlas = new TextureAtlas(Gdx.files.internal("sprites.txt"));
            } catch (GdxRuntimeException e){
                System.err.println("Are you trying to run a desktop instance?");
                atlas = new TextureAtlas(Gdx.files.external("AndroidStudioProjects\\SuperBooper\\android\\assets\\sprites.txt"));
            }
        }
    }

    public abstract void poked();

    abstract void selectBooper(eID eSpec);

    public String getSpecies(){
        return species;
    }

    private void setupAnimation(int id){
        selectBooper(eID.values()[id]);
        region = atlas.findRegion(species);
        this.numframes = region.getRegionWidth()/ FRAME_SIZE;
        keyFrames = new TextureRegion[numframes];
        int c=0;
        for (int i = (int)(Math.random()*numframes); c < numframes; i++) {
            if(i == numframes)i=0;
            keyFrames[c] = new TextureRegion(region, FRAME_SIZE *i,0, FRAME_SIZE, FRAME_SIZE);
            c++;
        }
        animation = new Animation(1f/numframes, keyFrames);
    }

    private void setupLocation(GameScreen game){
        do{
            setX((int)(Math.random()*SuperBoopers.V_WIDTH));
        }while(getX()+ FRAME_SIZE > SuperBoopers.V_WIDTH );

        do{
            setY((int)(Math.random()*SuperBoopers.V_HEIGHT));
        }while(getY()+ FRAME_SIZE > 5*SuperBoopers.V_HEIGHT/6
                ||getY() < SuperBoopers.V_HEIGHT/6);
    }

    public Animation<TextureRegion> draw(){
        return animation;
    }

    public abstract void move(GameScreen screen);
}
