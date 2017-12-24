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

	public final static int MENU = 0;
	public final static int MAIN = 1;
	public final static int SETTINGS = 2;
	public final static int CREDITS = 3;

	private boolean running = false;

	@Override
	public void create () {
		batch = new SpriteBatch();
		menuScreen = new MenuScreen(this);
		setScreen(menuScreen);
		running = true;
	}

	public void changeScreen(int screen){
		switch(screen){
			case MENU:
				if(menuScreen == null) menuScreen = new MenuScreen(this); // added (this)
				this.setScreen(menuScreen);
				break;
			case MAIN:
				if(gameScreen == null) gameScreen = new FieldScreen(this); // added (this)
				this.setScreen(gameScreen);
				break;
			/*case SETTINGS:
				if(mainScreen == null) mainScreen = new MainScreen(this); //added (this)
				this.setScreen(mainScreen);
				break;
			case CREDITS:
				if(endScreen == null) endScreen = new EndScreen(this);  // added (this)
				this.setScreen(endScreen);
				break;*/
		}
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
