package com.musicalpastries.superboopers;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.musicalpastries.superboopers.Screens.FieldScreen;

public class SuperBoopers extends Game implements ApplicationListener {
	public static final int V_WIDTH = 480;
	public static final int V_HEIGHT = 600;
	public SpriteBatch batch;

	private Texture slimeTexture;
	private Sprite slimeSprite;

	@Override
	public void create () {
		batch = new SpriteBatch();
		slimeTexture = new Texture("slime.png");
		slimeSprite = new Sprite(slimeTexture);
		//setScreen(new FieldScreen(this));
	}

	@Override
	public void render () {
		//clear screen
		Gdx.gl.glClearColor(1,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//game.batch.setProjectionMatrix(hud.stage.getCamera().combined);

		//hud.stage.draw();

		//render batch
		batch.begin();
		slimeSprite.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		slimeTexture.dispose();
	}

	@Override
	public void resume(){}

	@Override
	public void pause(){}

	@Override
	public void resize(int width, int height) {
		//viewport.update(width, height);
	}
}
