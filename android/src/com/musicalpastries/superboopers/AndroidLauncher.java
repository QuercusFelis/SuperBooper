package com.musicalpastries.superboopers;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;

import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.vision.barcode.Barcode;

public class AndroidLauncher extends AndroidApplication implements BScanner {
	private int currentApiVersion;


	public static final int REQUEST_CODE = 100;
	public static final int PERMISSION_REQUEST = 200;
	//TODO:
	int flagsJ = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
			| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
			| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
			| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
			| View.SYSTEM_UI_FLAG_FULLSCREEN;

	final int flagsK = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
			| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
			| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
			| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
			| View.SYSTEM_UI_FLAG_FULLSCREEN
			| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

	private SuperBoopers game;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

		currentApiVersion = android.os.Build.VERSION.SDK_INT;

		if(currentApiVersion >= Build.VERSION_CODES.KITKAT)
		{
			getWindow().getDecorView().setSystemUiVisibility(flagsK);
			// Code below is to handle presses of Volume up or Volume down.
			// Without this, after pressing volume buttons, the navigation bar will
			// show up and won't hide
			final View decorView = getWindow().getDecorView();
			decorView
					.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
					{
						@Override
						public void onSystemUiVisibilityChange(int visibility)
						{
							if((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0)
							{
								decorView.setSystemUiVisibility(flagsK);
							}
						}
					});
		}
		else if(currentApiVersion >= Build.VERSION_CODES.JELLY_BEAN)
		{
			getWindow().getDecorView().setSystemUiVisibility(flagsJ);
			// Code below is to handle presses of Volume up or Volume down.
			// Without this, after pressing volume buttons, the navigation bar will
			// show up and won't hide
			final View decorView = getWindow().getDecorView();
			decorView
					.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
					{
						@Override
						public void onSystemUiVisibilityChange(int visibility)
						{
							if((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0)
							{
								decorView.setSystemUiVisibility(flagsJ);
							}
						}
					});
		}

		if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
			ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST);
		}

		initialize(game = new SuperBoopers(this), config);
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		if (currentApiVersion >= Build.VERSION_CODES.KITKAT && hasFocus) {
			getWindow().getDecorView().setSystemUiVisibility(flagsK);
		}
		else if (currentApiVersion >= Build.VERSION_CODES.JELLY_BEAN && hasFocus) {
			getWindow().getDecorView().setSystemUiVisibility(flagsJ);
		}
	}

	@Override
	protected void onPause(){
		super.onPause();
		//TODO:
	}

	@Override
	protected void onResume(){
		super.onResume();
		if(currentApiVersion >= Build.VERSION_CODES.KITKAT)
		{
			getWindow().getDecorView().setSystemUiVisibility(flagsK);
			// Code below is to handle presses of Volume up or Volume down.
			// Without this, after pressing volume buttons, the navigation bar will
			// show up and won't hide
			final View decorView = getWindow().getDecorView();
			decorView
					.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
					{
						@Override
						public void onSystemUiVisibilityChange(int visibility)
						{
							if((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0)
							{
								decorView.setSystemUiVisibility(flagsK);
							}
						}
					});
		}
		if(currentApiVersion >= Build.VERSION_CODES.JELLY_BEAN)
		{
			getWindow().getDecorView().setSystemUiVisibility(flagsJ);
			// Code below is to handle presses of Volume up or Volume down.
			// Without this, after pressing volume buttons, the navigation bar will
			// show up and won't hide
			final View decorView = getWindow().getDecorView();
			decorView
					.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
					{
						@Override
						public void onSystemUiVisibilityChange(int visibility)
						{
							if((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0)
							{
								decorView.setSystemUiVisibility(flagsJ);
							}
						}
					});
		}


	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		if (requestCode == REQUEST_CODE && resultCode == RESULT_OK){
			Log.i("CODE", "onActivityResult");
			if(data != null){
				final Barcode barcode = data.getParcelableExtra("barcode");
				Log.i("CODE", barcode.displayValue);
				game.setLastScanned(barcode.displayValue);
				game.addBooperFromScan();
			}
		}

	}

	@Override
	public void scan() {
		Intent intent = new Intent(this, MainActivity.class);
		startActivityForResult(intent, REQUEST_CODE);
	}
}
