package com.musicalpastries.superboopers;


import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.musicalpastries.superboopers.Actors.Boopers.Booper;
import com.musicalpastries.superboopers.Actors.Boopers.Boopermon;
import com.musicalpastries.superboopers.Actors.Items.Goal;
import com.musicalpastries.superboopers.Actors.Items.Item;
import com.musicalpastries.superboopers.Actors.Items.ListItem;
import com.musicalpastries.superboopers.Actors.Items.Listing;
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
import java.util.Random;


/**
 * woodcat - 9/29/2017.
 */

public class SuperBoopers extends Game implements ApplicationListener {

	private final BScanner scanner;

	private String lastScanned;

	public static final int V_WIDTH = 504;
	public static final int V_HEIGHT = 896;

	private SpriteBatch batch;

	private Integer xp;
	private Integer lvl;

	private GameScreen gameScreen;
	private MenuScreen menuScreen;
	private InventoryScreen inventoryScreen;
	private GoalScreen goalScreen;
	private StoreScreen storeScreen;
	private CommunityScreen communityScreen;
	private SettingScreen settingScreen;

	private ArrayList<ListItem> items;
	private ArrayList<Booper> boopers;
	private ArrayList<ListItem> goals;
	private ArrayList<ListItem> listings;

	public ArrayList<ListItem> getItems() {
		return items;
	}

	public ArrayList<ListItem> getGoals() {
		return goals;
	}

	public ArrayList<ListItem> getListings() {
		return listings;
	}

	public void addRandItem() {
		items.add(new Item((int)(Math.random()*10+1), "test item", "temporary text", "test"));
	}

	public void addRandListings() {
		for (int i = 0; i < 10; i++) {
			listings.add(new Listing((int)(Math.random()*100+1), "test listing", "temporary text", "test"));
		}
	}

	public void addRandGoals() {
		for (int i = 0; i < 5; i++) {
			goals.add(new Goal((int)(Math.random()*5+1), "test goal", "temporary text", "test"));
		}
	}

	public enum eScreen{
		MENU,
		MAIN,
		INVENTORY,
		GOALS,
		STORE,
		COMMUNITY,
		GOOGLE,
		SETTINGS,
		DONATE,
		CREDITS
	}

	public SuperBoopers(BScanner scanner) {
		this.scanner = scanner;
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		boopers = new ArrayList<>();
		items = new ArrayList<>();
		listings = new ArrayList<>();
		goals = new ArrayList<>();
		Booper.setAtlas();
		ListItem.setAtlas();

		if(gameScreen == null){
			gameScreen = new GameScreen(this, eScreen.MENU);
		}

		changeScreen(eScreen.MENU, eScreen.MENU);
	}

	public ArrayList<Booper> getBoopers(){
		return boopers;
	}

	private void addBoopers(Booper booper){
		boopers.add(booper);
	}

	public void changeScreen(eScreen newScreen, eScreen lastScreen){
		switch(newScreen){
			case MENU:
				if(menuScreen == null) menuScreen = new MenuScreen(this);
				this.setScreen(menuScreen);
				menuScreen.setLastScreen(lastScreen);
				menuScreen.resume();
				break;
			case MAIN:
				gameScreen.setLastScreen(lastScreen);
				gameScreen.resume();
				this.setScreen(gameScreen);
				break;
			case INVENTORY:
				inventoryScreen = new InventoryScreen(this, lastScreen);
				inventoryScreen.setLastScreen(lastScreen);
				this.setScreen(inventoryScreen);
				break;
			case GOALS:
				goalScreen = new GoalScreen(this, lastScreen);
				goalScreen.setLastScreen(lastScreen);
				this.setScreen(goalScreen);
				break;
			case STORE:
				storeScreen = new StoreScreen(this, lastScreen);
				storeScreen.setLastScreen(lastScreen);
				this.setScreen(storeScreen);
				break;
			case COMMUNITY:
				if(communityScreen == null) communityScreen = new CommunityScreen(this, lastScreen);
				communityScreen.setLastScreen(lastScreen);
				this.setScreen(communityScreen);
				break;
			/*case GOOGLE:
				//if(googleScreen == null) googleScreen = new GoogleScreen(this, lastScreen);
				googleScreen.setLastScreen(lastScreen);
				this.setScreen(googleScreen);
				break;*/
			case SETTINGS:
				if(settingScreen == null) settingScreen = new SettingScreen(this, lastScreen);
				settingScreen.setLastScreen(lastScreen);
				this.setScreen(settingScreen);
				break;
			//DonateScreen and CreditsScreen use very few resources, instance variable unnecessary
			case DONATE:
				this.setScreen(new DonateScreen(this, lastScreen));
				break;
			case CREDITS:
				this.setScreen(new CreditsScreen(this, lastScreen));
				break;
		}
	}

	public void incrementXP(){
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

	public void setLastScanned(String code){
		lastScanned = code;
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

	public SpriteBatch getBatch() {
		return batch;
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

	public Boopermon addBooper() throws NumberFormatException{
		try{
			Random gen = new Random(Long.parseLong(lastScanned));
			int id = (int)Math.floor(gen.nextDouble()*10);
			double[] rgb = new double[3];
			for (int i = 0; i < rgb.length; i++) rgb[i] = gen.nextDouble();
			Boopermon b = new Boopermon(gameScreen.getContext(), id, rgb, lastScanned);
			addBoopers(b);
			scanner.tell(lastScanned);
			return b;
		}catch (NumberFormatException e){
			System.err.println(lastScanned);
			scanner.tell(lastScanned);
		}
		return null;
	}

	public void addBooperFromScan() throws NumberFormatException{
		Boopermon b = addBooper();
		if(b != null){
			gameScreen.showNewBooper(b);
		}
	}
}
