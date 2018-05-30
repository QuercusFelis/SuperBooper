package com.musicalpastries.superboopers.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.musicalpastries.superboopers.Actors.Booper;
import com.musicalpastries.superboopers.SuperBoopers;


/**
 * Andrew Groeling - 9/29/2017.
 */

public class GameScreen extends SuperScreen implements Screen {

    private OrthographicCamera gamecam;

    private Table table;
    private Table tableTop;

    private float fScale;

    private Label xpLabel;
    private Label lvlLabel;

    public GameScreen(SuperBoopers game){
        this.game = game;
        fScale = 1f;

        r= .45f;
        g= .1f;
        b= .5f;

        game.setXp(0);
        game.setLvl(1);

        gamecam = new OrthographicCamera();
        gamecam.setToOrtho(false, SuperBoopers.V_WIDTH, SuperBoopers.V_HEIGHT);
        stage = new Stage(new ExtendViewport(SuperBoopers.V_WIDTH, SuperBoopers.V_HEIGHT, gamecam));
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        table=new Table();
        tableTop=new Table();
//set up table
        table.setFillParent(true);
        table.top();
        if(stage.getActors().size ==0){
            stage.addActor(table);
        }

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle(skin.getDrawable("slider-vertical"), skin.getDrawable("scrollbar-horizontal"), skin.getDrawable("scrollbar-horizontal"), skin.getFont("subtitle"));

        //setting up objects in table
        xpLabel = new Label("XP: " + String.format("%03d", game.getXp()), new Label.LabelStyle(skin.getFont("font"), Color.WHITE));
        xpLabel.setFontScale(fScale);

        lvlLabel = new Label("Lvl: " + String.format("%01d", game.getLvl()), new Label.LabelStyle(skin.getFont("font"), Color.WHITE));
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
                game.changeScreen(SuperBoopers.MENU);
            }
        });
        scanButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.scan();
                testXP();
            }
        });
        game.addBoopers(new Booper(getContext(), (int)(Math.random()*Booper.atlas.getRegions().size)));
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
        game.testXP();
        xpLabel.setText("XP: " + String.format("%03d", game.getXp()));
    }

    @Override
    public void update(){
        gamecam.update();
        table.setFillParent(true);
    }

    @Override
    public void renderBatch() {
        game.batch.begin();
        game.batch.setProjectionMatrix(gamecam.combined);
        for (int i = 0; i < game.getBoopers().size(); i++) {
            game.batch.setColor(game.getBoopers().get(i).getColor());
            game.batch.draw(game.getBoopers().get(i).draw().getKeyFrame(dt, true), game.getBoopers().get(i).getX(), game.getBoopers().get(i).getY());
            System.out.print(game.getBoopers().get(i).draw().getKeyFrame(dt, true).toString());
        }
        game.batch.end();
    }

    @Override
    public void dispose(){
        game.batch.dispose();
    }
}
