package com.musicalpastries.superboopers;


import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.musicalpastries.superboopers.Screens.FieldScreen;
import com.musicalpastries.superboopers.Screens.MenuScreen;

public class SuperBoopers extends Game implements ApplicationListener {
	public static final int V_WIDTH = 480;
	public static final int V_HEIGHT = 640;
	public SpriteBatch batch;
	private FieldScreen gameScreen;
	private MenuScreen menuScreen;

	private boolean running = false;

	@Override
	public void create () {
		batch = new SpriteBatch();
		gameScreen = new FieldScreen(this);
		menuScreen = new MenuScreen(this);
		setScreen(gameScreen);
		running = true;
	}

	private void update(){
	}

	public void render (float dt) {
	}
	
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
