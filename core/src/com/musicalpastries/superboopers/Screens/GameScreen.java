package com.musicalpastries.superboopers.Screens;

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
        tableTop = new Table();

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle(
                skin.getDrawable("scrollbar-horizontal"),
                skin.getDrawable("scrollbar-horizontal"),
                skin.getDrawable("scrollbar-horizontal"),
                skin.getFont("subtitle")
        );

        //setting up objects in table
        xpLabel = new Label("XP: " + String.format("%03d", getGame().getXp()),
                new Label.LabelStyle(skin.getFont("font"), Color.WHITE));
        xpLabel.setFontScale(fScale);

        lvlLabel = new Label("Lvl: " + String.format("%01d", getGame().getLvl()),
                new Label.LabelStyle(skin.getFont("font"), Color.WHITE));
        lvlLabel.setFontScale(fScale);

        TextButton inventory = new TextButton("inventory", style);
        TextButton scanButton = new TextButton("SCAN", skin);

        //Table Row 0
        table.add(tableTop).expandX().fillX().padTop(10).top();
            //Inner Table Row 0
        tableTop.add(lvlLabel).expandX().top();
        tableTop.add(xpLabel).expandX().top();
            //Inner Table Row 1
        tableTop.row();
        tableTop.add(inventory).colspan(2).fill().padTop(10).top();
        //Table Row 1
        table.row();
        table.add(scanButton).expand().fillX().bottom().colspan(3);

        scanButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                getGame().scan();
                testXP();
            }
        });
        inventory.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                getGame().changeScreen(SuperBoopers.eScreen.INVENTORY);
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
        getGame().incrementXP();
        xpLabel.setText("XP: " + String.format("%03d", getGame().getXp()));
    }

    @Override
    public void update(){
        getGameCam().update();
        table.setFillParent(true);
    }

    @Override
    public void renderBatch() {
        getGame().batch.begin();
        getGame().batch.setProjectionMatrix(getGameCam().combined);
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
