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

public class GameScreen implements Screen {

    private SuperBoopers game;
    private OrthographicCamera gamecam;
    private Stage stage;
    private float dt;

    public Table table;
    private Integer xp;
    private Integer lvl;

    private float fScale;

    private Label xpLabel;
    private Label lvlLabel;

    public GameScreen(SuperBoopers game){
        this.game = game;
        table = new Table();
        fScale = 1.4f;
        xp = 0;
        lvl = 1;

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
                //game.changeScreen(SuperBoopers.INVENTORY);
                game.addBoopers(new Booper(4, 0, 0));
            }
        });
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
            game.batch.draw(game.getBoopers().get(i).draw().getKeyFrame(dt, true), game.getBoopers().get(i).getXPos(), game.getBoopers().get(i).getYPos());
        }
        game.batch.end();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        /*System.out.println("Width: "+Gdx.graphics.getWidth());
        System.out.println("Height: "+Gdx.graphics.getHeight());*/
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
        game.batch.dispose();
    }
}
