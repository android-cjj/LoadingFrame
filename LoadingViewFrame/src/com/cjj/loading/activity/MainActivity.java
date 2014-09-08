package com.cjj.loading.activity;

import static com.cjj.loading.activity.LoadingActivity.EXTRA_FRAGMENT;
import static com.cjj.loading.activity.LoadingActivity.EXTRA_TITLE;
import static com.cjj.loading.activity.LoadingActivity.FRAGMENT_DEFAULT;
import static com.cjj.loading.activity.LoadingActivity.FRAGMENT_EMPTY;
import static com.cjj.loading.activity.LoadingActivity.FRAGMENT_FAILURE;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {
	
	private String[] title = new String[]{"DefaultView", "EmptyView", "FairView"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,title);
		setListAdapter(adapter);
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Intent intent = new Intent(MainActivity.this, LoadingActivity.class);
		intent.putExtra(EXTRA_TITLE, title[position]);
		switch(position)
		{
		  case 0:
              intent.putExtra(EXTRA_FRAGMENT, FRAGMENT_DEFAULT);
              break;
          case 1:
              intent.putExtra(EXTRA_FRAGMENT, FRAGMENT_EMPTY);
              break;
          case 2:
              intent.putExtra(EXTRA_FRAGMENT,FRAGMENT_FAILURE);
              break;
		}
		startActivity(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}

}
