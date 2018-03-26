package com.musicalpastries.superboopers.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
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
import com.musicalpastries.superboopers.Actors.Booper;
import com.musicalpastries.superboopers.SuperBoopers;

/**
 * Andrew Groeling - 9/29/2017.
 */

public class GameScreen extends SuperScreen implements Screen {

    private OrthographicCamera gamecam;
    private float dt;

    public Table table;

    private float fScale;

    private Label xpLabel;
    private Label lvlLabel;

    public GameScreen(SuperBoopers game){
        this.game = game;
        table = new Table();
        fScale = 1.4f;
        game.setXp(0);
        game.setLvl(1);

        gamecam = new OrthographicCamera();
        gamecam.setToOrtho(false, SuperBoopers.V_WIDTH, SuperBoopers.V_HEIGHT);
        stage = new Stage(new ExtendViewport(SuperBoopers.V_WIDTH, SuperBoopers.V_HEIGHT, gamecam));
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
//set up table
        table.setFillParent(true);
        table.top();
        stage.addActor(table);
        Skin skin = new Skin(Gdx.files.internal("skin/pixthulhu-ui.json"));

        //setting up objects in table
        xpLabel = new Label("XP: " + String.format("%03d", game.getXp()), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        xpLabel.setFontScale(fScale);

        lvlLabel = new Label("Level: " + String.format("%01d", game.getLvl()), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
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
                //game.changeScreen(SuperBoopers.INVENTORY);
                game.addBoopers(new Booper(getContext() , 4, 0, 0));
                testXP();
            }
        });
    }

    public GameScreen getContext(){
        return this;
    }

    public void setXp(Integer xp) {
        game.setXp(xp);
    }

    public void setLvl(Integer lvl) {
        game.setLvl(lvl);
    }

    public void testXP(){
        game.testXP();
        xpLabel.setText("XP: " + String.format("%03d", game.getXp()));
    }

    public void update(){
        gamecam.update();
        table.setFillParent(true);
    }

    @Override
    public void render(float delta) {
        dt += Gdx.graphics.getDeltaTime();
        //clear screen
        Gdx.gl.glClearColor(.7f,0,.3f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update();

        //drawing
        game.batch.begin();
        game.batch.setProjectionMatrix(gamecam.combined);
        for (int i = 0; i < game.getBoopers().size(); i++) {
            game.batch.setColor(game.getBoopers().get(i).getColor());
            game.batch.draw(game.getBoopers().get(i).draw().getKeyFrame(dt, true), game.getBoopers().get(i).getX(), game.getBoopers().get(i).getY());
        }
        game.batch.end();
        stage.draw();
    }
}
