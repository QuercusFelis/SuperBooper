package com.musicalpastries.superboopers.Screens;

import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.musicalpastries.superboopers.SuperBoopers;

/**
 * Created by loads on 10/31/2018.
 */

public abstract class ListScreen extends SuperScreen {

    protected Table items;
    protected Dialog itemInfo;

    public ListScreen(SuperBoopers game, SuperBoopers.eScreen lastScreen) {
        super(game, lastScreen);
    }
}
