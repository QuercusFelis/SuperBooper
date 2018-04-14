package com.musicalpastries.superboopers.desktop;

import com.badlogic.gdx.Gdx;
import com.musicalpastries.superboopers.BScanner;

/**
 * loads - 4/13/2018.
 */

public class Scan implements BScanner {
    @Override
    public void scan() {
        Gdx.app.log("Scan", "A wild booper wishes it could appear!");
    }
}
