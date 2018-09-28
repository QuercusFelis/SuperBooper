package com.musicalpastries.superboopers.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.musicalpastries.superboopers.SuperBoopers;


/**
 * Andrew Groeling - 9/29/2017.
 */

public class GameScreen extends SuperScreen {

    private OrthographicCamera gamecam;
    private float fScale;

    private Table tableTop;
    private Label xpLabel;
    private Label lvlLabel;

    public GameScreen(SuperBoopers game){
        super(game, new OrthographicCamera());
        fScale = 1f;

        r= .3f;
        g= .7f;
        b= .1f;

        game.setXp(0);
        game.setLvl(1);
    }

    @Override
    public void show() {
        super.show();
        Gdx.input.setInputProcessor(getStage());
        if(getStage().getActors().size ==0){
            getStage().addActor(table);
        }
        tableTop = new Table();

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle(skin.getDrawable("slider-vertical"), skin.getDrawable("scrollbar-horizontal"), skin.getDrawable("scrollbar-horizontal"), skin.getFont("subtitle"));

        //setting up objects in table
        xpLabel = new Label("XP: " + String.format("%03d", getGame().getXp()), new Label.LabelStyle(skin.getFont("font"), Color.WHITE));
        xpLabel.setFontScale(fScale);

        lvlLabel = new Label("Lvl: " + String.format("%01d", getGame().getLvl()), new Label.LabelStyle(skin.getFont("font"), Color.WHITE));
        lvlLabel.setFontScale(fScale);

        TextButton inventory = new TextButton("inventory", style);
        inventory.setName("inventory");

        TextButton back = new TextButton("<", skin);
        back.setName("back");
        TextButton scanButton = new TextButton("SCAN", skin);
        scanButton.setName("scan");

        //table
        table.add(back).pad(10).top().left();
        table.add(tableTop).fillX().padTop(10).top();

        tableTop.add(lvlLabel).expandX().top();
        tableTop.add(xpLabel).expandX().top();
        tableTop.row();
        tableTop.add(inventory).colspan(2).fill().padTop(10).top();

        table.row();
        table.add(scanButton).expand().fillX().bottom().colspan(3);

        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                getGame().changeScreen(SuperBoopers.MENU);
            }
        });
        scanButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                getGame().scan();
                testXP();
            }
        });
    }

    public GameScreen getContext(){
        return this;
    }

    public Label getLvlLabel(){
        return lvlLabel;
    }

    public Table getTable(){
        table.validate();
        return table;
    }

    public void testXP(){
        getGame().testXP();
        xpLabel.setText("XP: " + String.format("%03d", getGame().getXp()));
    }

    @Override
    public void update(){
        gamecam.update();
        table.setFillParent(true);
    }

    @Override
    public void renderBatch() {
        getGame().batch.begin();
        getGame().batch.setProjectionMatrix(gamecam.combined);
        for (int i = 0; i < getGame().getBoopers().size(); i++) {
            getGame().batch.setColor(getGame().getBoopers().get(i).getColor());
            getGame().batch.draw(getGame().getBoopers().get(i).draw().getKeyFrame(dt, true), getGame().getBoopers().get(i).getX(), getGame().getBoopers().get(i).getY());
            System.out.print(getGame().getBoopers().get(i).draw().getKeyFrame(dt, true).toString());
        }
        getGame().batch.end();
    }

    @Override
    public void dispose(){
        getGame().batch.dispose();
    }

}
