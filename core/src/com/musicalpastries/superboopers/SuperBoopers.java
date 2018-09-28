package com.musicalpastries.superboopers;


import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.musicalpastries.superboopers.Actors.Booper;
import com.musicalpastries.superboopers.Screens.CommunityScreen;
import com.musicalpastries.superboopers.Screens.CreditsScreen;
import com.musicalpastries.superboopers.Screens.DonateScreen;
import com.musicalpastries.superboopers.Screens.GameScreen;
import com.musicalpastries.superboopers.Screens.GoalScreen;
import com.musicalpastries.superboopers.Screens.InventoryScreen;
import com.musicalpastries.superboopers.Screens.MenuScreen;
import com.musicalpastries.superboopers.Screens.SettingScreen;
import com.musicalpastries.superboopers.Screens.StoreScreen;

import java.util.ArrayList;


/**
 * Andrew Groeling - 9/29/2017.
 */

public class SuperBoopers extends Game implements ApplicationListener {

	private final BScanner scanner;

	private String lastScanned;

	public static final int V_WIDTH = 504;
	public static final int V_HEIGHT = 896;

	public SpriteBatch batch;
	private ArrayList<Booper> boopers;
	private Integer xp;
	private Integer lvl;

	private GameScreen gameScreen;
	private MenuScreen menuScreen;

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


	public SuperBoopers(BScanner scanner) {
		this.scanner = scanner;
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		boopers = new ArrayList<Booper>();

		changeScreen(MENU);
		running = true;
		System.out.println("SuperBoopers create");
	}

	public ArrayList<Booper> getBoopers(){
		ArrayList<Booper> boopers = this.boopers;
		return boopers;
	}

	public void addBoopers(Booper booper){
		boopers.add(booper);
	}

	public void changeScreen(int screen){
		switch(screen){
			case MENU:

				if(menuScreen == null) menuScreen = new MenuScreen(this); // added (this)
				this.setScreen(menuScreen);
				menuScreen.resume();
				break;
			case MAIN:
				if(gameScreen == null){
					gameScreen = new GameScreen(this);
//					addBoopers(new Booper(gameScreen.getContext(), (int)(Math.random()*Booper.atlas.getRegions().size)));
				}// added (this)
				gameScreen.resume();
				this.setScreen(gameScreen);
				break;
			case INVENTORY:
				//if(inventoryScreen == null) inventoryScreen = new InventoryScreen(this); //added (this)
				this.setScreen(new InventoryScreen(this));
				break;
			case GOALS:
				//if(goalsScreen == null) goalsScreen = new GoalsScreen(this); //added (this)
				this.setScreen(new GoalScreen(this));
				break;
			case STORE:
				//if(storeScreen == null) storeScreen = new StoreScreen(this); //added (this)
				this.setScreen(new StoreScreen(this));
				break;
			case COMMUNITY:
				//if(communityScreen == null) communityScreen = new CommunityScreen(this); //added (this)
				this.setScreen(new CommunityScreen(this));
				break;
			/*case GOOGLE:
				//if(googleScreen == null) googleScreen = new GoogleScreen(this); //added (this)
				this.setScreen(new GoogleScreen(this));
				break;*/
			case SETTINGS:
				//if(settingsScreen == null) settingsScreen = new SettingsScreen(this); //added (this)
				this.setScreen(new SettingScreen(this));
				break;
			case DONATE:
				//if(donateScreen == null) donateScreen = new DonateScreen(this); //added (this)
				this.setScreen(new DonateScreen(this));
				break;
			case CREDITS:
				//if(creditsScreen == null) creditsScreen = new CreditsScreen(this); //added (this)
				this.setScreen(new CreditsScreen(this));
				break;

		}
	}

	public void testXP(){
		xp++;
	}

	public void setXp(Integer xp) {
		this.xp = xp;
	}

	public void setLvl(Integer lvl) {
		this.lvl = lvl;
	}

	public void scan(){
		scanner.scan();
	}

	public void setLastScanned(String format){
		lastScanned = format;
	}

	public Integer getXp() {
		return xp;
	}

	public Integer getLvl() {
		return lvl;
	}

	public GameScreen getGameScreen(){
		return gameScreen;
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
		if(boopers.size() > 0){
			System.out.println(boopers.get(0).getSpecies());
			System.out.println(boopers.get(0).draw().getKeyFrames().length+"");
		}
	}

	@Override
	public void pause(){
		super.pause();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	public void addBooperFromScan() {
		gameScreen.getLvlLabel().setText(lastScanned);
		int id = Integer.parseInt(lastScanned.substring(2,3));
		addBoopers(new Booper(gameScreen.getContext(), id));
		System.out.println(lastScanned);
	}
}
