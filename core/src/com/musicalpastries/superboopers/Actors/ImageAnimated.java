package com.musicalpastries.superboopers.Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * loads - 10/14/2018.
 */
public class ImageAnimated extends Actor {

    private Animation animation;

    public ImageAnimated(Animation animation) {
        this.animation = animation;
    }

    public Animation<TextureRegion> draw() {
        return animation;
    }
}
