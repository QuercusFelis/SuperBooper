package com.musicalpastries.superboopers.Actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.musicalpastries.superboopers.Screens.GameScreen;
import com.musicalpastries.superboopers.SuperBoopers;

/**
 * woodcat - 10/6/2018.
 */
public class Boopermon extends Booper {

    private boolean arrived;
    private int wait;
    private int destX;
    private int destY;
    private float deltaX;
    private float deltaY;

    public Boopermon(GameScreen game, int id) {
        super(game, id);
        newDestination();
        wait = (int)(Math.random()*500);
        if(wait % 2 == 1){
            arrived = false;
        }else arrived = true;
    }

    @Override
    public void poked() {
        game.testXP();
    }

    @Override
    public void selectBooper(eID eSpec){
        switch(eSpec){
            case DUCK:
                species = "duck";
                setColor(new Color((float)(Math.random()*1.5), (float)(Math.random()*1.5), (float)(Math.random()*1.5), 1));
                break;
            case SLIME:
                species = "slime";
                setColor(new Color((float)(Math.random()+.3), (float)(Math.random()+.3), (float)(Math.random()+.3), .9f));
                break;
            case PILZ:
                species = "pilz";
                setColor(new Color((float)(Math.random()+.3), (float)(Math.random()+.3), (float)(Math.random()+.3), 1));
                break;
            case SWITCH:
                species = "switch";
                setColor(new Color((float)(Math.random()+.3), (float)(Math.random()+.3), (float)(Math.random()+.3), 1));
                break;
            case BONSAI:
                species = "bonsai";
                if(Math.ceil(Math.random()*2)%2==1){ setColor(new Color((float)(Math.random()/2), (float)(Math.random()+.15), (float)(Math.random()/2), 1)); }
                else{ setColor(new Color((float)(Math.random()+.35), (float)(Math.random()/2), (float)(Math.random()+.25), 1)); }
                break;
            case SPINPHONE:
                species = "spinPhone";
                setColor(new Color(1,1,1, 1));
                break;
            case PINECONE:
                species = "pinecone";
                setColor(new Color((float)(Math.random()/2+.5), (float)(.5), (float)(.2), 1));
                break;
            case BOX:
                species = "box";
                setColor(new Color((float)(Math.random()+.3), (float)(Math.random()+.3), (float)(Math.random()+.3), 1));
                break;
            case STEAK:
                species = "steak";
                setColor(new Color((float)(Math.random()+.3), (float)(Math.random()+.3), (float)(Math.random()+.3), 1));
                break;
            case TENNIS:
                species = "tennis";
                setColor(new Color((float)(Math.random()+.3), (float)(Math.random()+.3), (float)(Math.random()+.3), 1));
                break;
        }
    }

    @Override
    public Animation<TextureRegion> draw() {
        return super.draw();
    }

    private void newDestination() {
        arrived = false;
        wait = (int)Math.random()*500+250;
        do{
            destX = (int)(Math.random()*SuperBoopers.V_WIDTH)+1;
        }while(destX+FRAME_SIZE > SuperBoopers.V_WIDTH || destX < 0);
        do{
            destY = (int)(Math.random()*SuperBoopers.V_HEIGHT)+1;
        }while(destY+FRAME_SIZE > SuperBoopers.V_HEIGHT-100
                ||destY < 100);
        float dt = Math.max(Math.abs(destY - getY()), Math.abs(destX - getX()));
        deltaY = (destY-getY())/dt;
        deltaX = (destX-getX())/dt;
    }

    @Override
    public void move(GameScreen screen) {
        if(!arrived){
            if((getX() <= destX+2 && getX() >= destX-2) && (getY() <= destY+2 && getY() >= destY-2)){
                arrived = true;
            } else {
                if (deltaX >=0)setX(getX()+deltaX);
                else setX(getX()+deltaX);

                if (deltaY >=0)setY(getY()+deltaY);
                else setY(getY()+deltaY);
            }
        } else if(wait == 0){
            newDestination();
        } else {
            wait--;
        }

    }
}
