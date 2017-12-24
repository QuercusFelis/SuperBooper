package com.musicalpastries.superboopers;


import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.musicalpastries.superboopers.Screens.FieldScreen;
import com.musicalpastries.superboopers.Screens.MenuScreen;

public class SuperBoopers extends Game {
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
		setScreen(menuScreen);
		running = true;
	}

	@Override
	public void render(){
		super.render();
	}

	@Override
	public void dispose () {
		super.dispose();
	}

	@Override
	public void resume(){
		super.resume();
	}

	@Override
	public void pause(){
		super.pause();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}
}
