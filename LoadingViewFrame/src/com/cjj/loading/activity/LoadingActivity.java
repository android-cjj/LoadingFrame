package com.cjj.loading.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class LoadingActivity extends ActionBarActivity {
	public static final String EXTRA_TITLE = "com.cjj.loading.extras.EXTRA_TITLE";
	public static final String EXTRA_FRAGMENT = "com.cjj.loading.extras.EXTRA_FRAGMENT";
	public static final int FRAGMENT_DEFAULT = 0;
	public static final int FRAGMENT_EMPTY = 1;
	public static final int FRAGMENT_FAILURE = 2;

	private Fragment mFragment;
	private ActionBar actionBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle(getIntent().getStringExtra(EXTRA_TITLE));
		actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		mFragment = getSupportFragmentManager().findFragmentById(android.R.id.content);
		
		if (mFragment == null)
		{
			int fragmentId = getIntent().getIntExtra(EXTRA_FRAGMENT,
					FRAGMENT_DEFAULT);
			switch (fragmentId) {
			case FRAGMENT_DEFAULT:
				mFragment = DefaultFragment.newInstance();
				break;
			case FRAGMENT_EMPTY:
				mFragment = EmptyFragment.newInstance();
				break;
			case FRAGMENT_FAILURE:
				mFragment = FailureFragment.newInstance();
				break;

			}
			getSupportFragmentManager().beginTransaction()
					.add(android.R.id.content, mFragment).commit();
		}
	}
	
	
}
