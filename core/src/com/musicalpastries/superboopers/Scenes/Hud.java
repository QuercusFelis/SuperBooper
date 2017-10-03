package com.musicalpastries.superboopers.Scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.musicalpastries.superboopers.SuperBoopers;

/**
 * Created by Andrew Groeling on 10/2/2017.
 */

public class Hud {
    public Stage stage;
    private Viewport viewport;

    private Integer xp;

    Label xpLabel;
    public Hud(SpriteBatch sb){
        xp = 0;

        viewport = new FitViewport(SuperBoopers.V_WIDTH, SuperBoopers.V_HEIGHT, new OrthographicCamera());
        stage =  new Stage(viewport, sb);

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        xpLabel = new Label("XP: " + String.format("%03d", xp), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        table.add(xpLabel).expandX().padTop(10);

        stage.addActor(table);
    }
}
