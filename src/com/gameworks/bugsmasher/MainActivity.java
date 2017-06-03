package com.gameworks.bugsmasher;

import com.badlogic.gdx.ApplicationListener;
import com.gameworks.utils.BaseActivity;

public class MainActivity extends BaseActivity {

	@Override
	public ApplicationListener getGame() {
		// TODO Auto-generated method stub
		return new BugSmasher();
	} 
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		showAd();
	}
}