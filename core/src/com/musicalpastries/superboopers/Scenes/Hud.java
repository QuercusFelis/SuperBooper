package com.musicalpastries.superboopers.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.musicalpastries.superboopers.SuperBoopers;

/**
 * Andrew Groeling - 10/2/2017.
 */

public class Hud implements Screen {
    private SuperBoopers game;
    public Stage stage;

    private Integer xp;
    private Integer lvl;

    private float fScale;

    private Label xpLabel;
    private Label lvlLabel;
    public Hud(SuperBoopers game){
        //set defaults
        this.game = game;
        fScale = 1.4f;
        xp = 0;
        lvl = 1;

        //setup stage
        stage =  new Stage(new ExtendViewport(SuperBoopers.V_WIDTH, SuperBoopers.V_HEIGHT, new OrthographicCamera()));
        Gdx.input.setInputProcessor(stage);

        show();
    }

    public void setfScale(float fScale){
        fScale = this.fScale;
    }
    public float getfScale(){
        return fScale;
    }

    public void setXp(Integer xp){
        xp = this.xp;
    }
    public Integer getXp(){
        return xp;
    }

    public void setLvl(Integer lvl){
        lvl = this.lvl;
    }
    public Integer getLvl(){
        return lvl;
    }

    @Override
    public void show() {
        //set up table
        Table table = new Table();
        table.top();
        table.setFillParent(true);
        stage.addActor(table);
        Skin skin = new Skin(Gdx.files.internal("skin/pixthulhu-ui.json"));

        //setting up objects in table
        xpLabel = new Label("XP: " + String.format("%03d", xp), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        xpLabel.setFontScale(fScale);

        lvlLabel = new Label("Level: " + String.format("%01d", lvl), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        lvlLabel.setFontScale(fScale);

        TextButton back = new TextButton("<", skin);
        TextButton scan = new TextButton("SCAN", skin);

        //table
        table.add(back).pad(10);
        table.add(lvlLabel).expandX().padTop(10).top();
        table.add(xpLabel).expandX().padTop(10).top();

        table.row();
        table.add(scan).expand().fillX().bottom().colspan(3);

        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.changeScreen(SuperBoopers.MENU);
            }
        });
        scan.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //finalgame.changeScreen(SuperBoopers.INVENTORY);
            }
        });
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
