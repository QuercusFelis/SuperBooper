package com.musicalpastries.superboopers.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.musicalpastries.superboopers.SuperBoopers;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "*Super Boopers*";
		config.width = SuperBoopers.V_WIDTH;
		config.height = SuperBoopers.V_HEIGHT;
		
		new LwjglApplication(new SuperBoopers(new Scan()), config);
	}
}
