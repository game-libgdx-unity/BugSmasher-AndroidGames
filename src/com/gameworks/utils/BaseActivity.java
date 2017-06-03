package com.gameworks.utils;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public abstract class BaseActivity extends AndroidApplication implements
		AndroidService {

	private InterstitialAd interstitial;

	private AdRequest adRequest;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		handler = new Handler();
		// Create the interstitial.
		interstitial = new InterstitialAd(this);
		interstitial.setAdUnitId("ca-app-pub-5711560291431485/5644752856");
		interstitial.setAdListener(new AdListener() {
			@Override
			public void onAdClosed() {
				interstitial.loadAd(adRequest);
				super.onAdClosed();
			}
		});
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration(); 
		// Create ad request.
		adRequest = new AdRequest.Builder().build();

		// Begin loading your interstitial.
		interstitial.loadAd(adRequest);
		cfg.useGL20 = getUseGL20();
		cfg.useAccelerometer = getUsAccelerometer();
		cfg.useCompass = getUseCompass();
		cfg.useWakelock = getUsWakelock();

		initialize(getGame(), cfg);
	}

	public abstract ApplicationListener getGame();

	public boolean getUseGL20() {
		return true;
	}

	public boolean getUsAccelerometer() {
		return false;
	}

	public boolean getUseCompass() {
		return false;
	}

	public boolean getUsWakelock() {
		return false;
	}
	@Override
	public void showAd() {
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				try {

					if (interstitial.isLoaded()) {
						interstitial.show();
					}
				} catch (Exception ex) {
					return;
				}
			}
		}, 200);
	}
	@Override
	public void onGameExit() {
		// TODO Auto-generated method stub
		Gdx.app.exit();
	}

	@Override
	public void moreGame() {
		Intent browserIntent = new Intent(
				Intent.ACTION_VIEW,
				Uri.parse("https://play.google.com/store/apps/developer?id=GameViet+Works"));
		startActivity(browserIntent);
	}

	@Override
	public void rate() {
		Uri uri = Uri.parse("market://details?id=" + getPackageName());
		Intent myAppLinkToMarket = new Intent(Intent.ACTION_VIEW, uri);
		try {
			startActivity(myAppLinkToMarket);
		} catch (ActivityNotFoundException e) {
			Toast.makeText(this, " unable to find market app",
					Toast.LENGTH_LONG).show();
		}
	}
}