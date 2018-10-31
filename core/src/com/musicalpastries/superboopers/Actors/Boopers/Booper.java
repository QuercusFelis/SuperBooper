package com.musicalpastries.superboopers.Actors.Boopers;

import com.musicalpastries.superboopers.Actors.SuperBooperActor;
import com.musicalpastries.superboopers.Screens.GameScreen;
import com.musicalpastries.superboopers.SuperBoopers;

import java.util.Date;


/**
 * woodcat - 10/19/2017.
 */

public abstract class Booper extends SuperBooperActor {
    GameScreen game;

    private String name;
    private Date created;
    private int lvl;
    //animated sprite variables
    String species;

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

    Booper(GameScreen game, int id, double[] rgb){
        setupGraphics(id, rgb);
        setupLocation(game);
        lvl = 0;
    }

    protected void setupGraphics(int id, double[] rgb){
        selectBooper(eID.values()[id], rgb);
        region = atlas.findRegion(species);
        setupAnimation();
        selectBooper(Booper.eID.values()[id],
                rgb);
    }

    public static void setAtlas(){
        setAtlas("sprites.txt", "AndroidStudioProjects/SuperBooper/android/assets/sprites.txt");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated() {
        return created;
    }

    void setCreated(Date created) {
        this.created = created;
    }

    public int getLvl() {
        return lvl;
    }

    public void incrementLvl() {
        this.lvl++;
    }

    abstract void selectBooper(eID eSpec, double[] rgb);

    private void setupLocation(GameScreen game){
        do{
            setX((int)(Math.random()*SuperBoopers.V_WIDTH));
        }while(getX()+ FRAME_SIZE > SuperBoopers.V_WIDTH );

        do{
            setY((int)(Math.random()*SuperBoopers.V_HEIGHT));
        }while(getY()+ FRAME_SIZE > 5*SuperBoopers.V_HEIGHT/6
                ||getY() < SuperBoopers.V_HEIGHT/6);
    }

    public abstract void move(GameScreen screen);
}
