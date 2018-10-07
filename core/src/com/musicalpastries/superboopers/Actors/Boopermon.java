package com.musicalpastries.superboopers.Actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.musicalpastries.superboopers.Screens.GameScreen;

/**
 * woodcat - 10/6/2018.
 */
public class Boopermon extends Booper {

    public Boopermon(GameScreen game, int id) {
        super(game, id);
    }

    @Override
    public void selectBooper(eID eSpec){
        //TODO: make specific color profiles
        switch(eSpec){
            case DUCK:
                species = "duck";
                setColor(new Color((float)(Math.random()+.3), (float)(Math.random()+.3), (float)(Math.random()+.3), 1));
                break;
            case SLIME:
                species = "slime";
                setColor(new Color((float)(Math.random()+.3), (float)(Math.random()+.3), (float)(Math.random()+.3), 1));
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
                setColor(new Color((float)(Math.random()+.3), (float)(Math.random()+.3), (float)(Math.random()+.3), 1));
                break;
            case SPINPHONE:
                species = "spinPhone";
                setColor(new Color((float)(Math.random()+.3), (float)(Math.random()+.3), (float)(Math.random()+.3), 1));
                break;
            case PINECONE:
                species = "pinecone";
                setColor(new Color((float)(Math.random()+.3), (float)(Math.random()+.3), (float)(Math.random()+.3), 1));
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

    //TODO: change position?
    @Override
    public Animation<TextureRegion> draw() {
        return super.draw();
    }
}
