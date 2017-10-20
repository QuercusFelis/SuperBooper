package com.musicalpastries.superboopers;


import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.musicalpastries.superboopers.Screens.FieldScreen;

public class SuperBoopers extends Game implements ApplicationListener {
	public static final int V_WIDTH = 480;
	public static final int V_HEIGHT = 600;
	public SpriteBatch batch;
	FieldScreen screen;

	private Thread thread;
	private boolean running = false;

	@Override
	public void create () {
		batch = new SpriteBatch();
		screen = new FieldScreen(this);
		setScreen(screen);
	}

	private void update(){

	}

	/*@Override
	public void render () {
		//clear screen
		Gdx.gl.glClearColor(1,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		this.batch.setProjectionMatrix(hud.stage.getCamera().combined);

		hud.stage.draw();

		//render batch
		batch.begin();
		slimeSprite.draw(batch);
		batch.end();
	}*/
	
	@Override
	public void dispose () {
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
