package com.musicalpastries.superboopers.Scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.musicalpastries.superboopers.SuperBoopers;

/*
 * Created by Andrew Groeling on 10/2/2017.
 */

public class Hud {
    public Stage stage;
    private Viewport viewport;

    private Integer xp;
    private Integer lvl;

    private Label xpLabel;
    private Label lvlLabel;
    public Hud(SpriteBatch sb){
        xp = 0;
        lvl = 1;

        viewport = new ExtendViewport(SuperBoopers.V_WIDTH, SuperBoopers.V_HEIGHT, new OrthographicCamera());
        stage =  new Stage(viewport, sb);

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        xpLabel = new Label("XP: " + String.format("%03d", xp), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        lvlLabel = new Label("Level: " + String.format("%01d", lvl), new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        xpLabel.setFontScale(1.3f);
        lvlLabel.setFontScale(1.3f);

        table.add(lvlLabel).expandX().padTop(10);
        table.add(xpLabel).expandX().padTop(10);

        stage.addActor(table);
    }

}
