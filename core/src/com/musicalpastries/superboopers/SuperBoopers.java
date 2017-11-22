package com.musicalpastries.superboopers;


import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.PauseableThread;
import com.musicalpastries.superboopers.Screens.FieldScreen;

public class SuperBoopers extends Game implements ApplicationListener {
	public static final int V_WIDTH = 540;
	public static final int V_HEIGHT = 960;
	public SpriteBatch batch;
	FieldScreen screen;

	private boolean running = false;

	@Override
	public void create () {
		batch = new SpriteBatch();
		screen = new FieldScreen(this);
		setScreen(screen);
		running = true;
		//running();
	}

	private void running(){
		long timeLast = System.nanoTime();
		final double ticks = 60D;
		double ns = 1000000000 / ticks;
		float dt = 0;

		while (running) {
			long timeNow = System.nanoTime();
			dt += (timeNow - timeLast) / ns;
			timeLast = timeNow;

			if (dt >= 1) {
				update();
				render(dt);
				dt--;
			}
		}
	}

	private void update(){
		screen.update();
	}

	public void render (float dt) {
		screen.render(dt);
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
