package com.musicalpastries.superboopers;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.musicalpastries.superboopers.Screens.CreditsScreen;
import com.musicalpastries.superboopers.Screens.GameScreen;
import com.musicalpastries.superboopers.Screens.MenuScreen;


/**
 * Andrew Groeling - 9/29/2017.
 */

public class SuperBoopers extends Game {
	public static final int V_WIDTH = 504;
	public static final int V_HEIGHT = 896;

	public SpriteBatch batch;

/*	private GameScreen gameScreen;
	private MenuScreen menuScreen;*/

	public final static int MENU = 0;
	public final static int MAIN = 1;
	public final static int INVENTORY = 2;
	public final static int GOALS = 3;
	public final static int STORE = 4;
	public final static int COMMUNITY = 5;
	public final static int GOOGLE = 6;
	public final static int SETTINGS = 7;
	public final static int DONATE = 8;
	public final static int CREDITS = 9;

	private boolean running = false;

	@Override
	public void create () {
		batch = new SpriteBatch();

		setScreen(new MenuScreen(this));
		running = true;
	}

	public void changeScreen(int screen){
		switch(screen){
			case MENU:
				//if(menuScreen == null) menuScreen = new MenuScreen(this); // added (this)
				this.setScreen(new MenuScreen(this));
				break;
			case MAIN:
				//if(gameScreen == null) gameScreen = new GameScreen(this); // added (this)
				this.setScreen(new GameScreen(this));
				break;
			/*case INVENTORY:
				//if(inventoryScreen == null) inventoryScreen = new InventoryScreen(this); //added (this)
				this.setScreen(new InventoryScreen(this));
				break;
			case GOALS:
				//if(goalsScreen == null) goalsScreen = new GoalsScreen(this); //added (this)
				this.setScreen(new GoalsScreen(this));
				break;
			case STORE:
				//if(storeScreen == null) storeScreen = new StoreScreen(this); //added (this)
				this.setScreen(new StoreScreen(this));
				break;
			case COMMUNITY:
				//if(communityScreen == null) communityScreen = new CommunityScreen(this); //added (this)
				this.setScreen(new CommunityScreen(this));
				break;
			case GOOGLE:
				//if(googleScreen == null) googleScreen = new GoogleScreen(this); //added (this)
				this.setScreen(new GoogleScreen(this));
				break;*/
			case CREDITS:
				//if(creditsScreen == null) creditsScreen = new CreditsScreen(this); //added (this)
				this.setScreen(new CreditsScreen(this));
				break;
			/*case DONATE:
				//if(donateScreen == null) donateScreen = new DonateScreen(this); //added (this)
				this.setScreen(new DonateScreen(this));
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
