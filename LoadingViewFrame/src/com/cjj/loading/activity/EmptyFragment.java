package com.cjj.loading.activity;

import com.cjj.callback.ReLoadCallbackListener;
import com.cjj.loading.LoadingCjjLayout;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class EmptyFragment extends Fragment implements ReLoadCallbackListener{
	private Handler mHandler;
	private LoadingCjjLayout loadingCjjLayout;
	
	public static EmptyFragment newInstance() {
		EmptyFragment fragment = new EmptyFragment();
		return fragment;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_test, null);
		loadingCjjLayout = new LoadingCjjLayout(getActivity(), view);
		loadingCjjLayout.setReLoadCallbackListener(this);
		return loadingCjjLayout;
	}
	
	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
	}
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		
		showData();
		super.onActivityCreated(savedInstanceState);
	}
	
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.refresh, menu);
		super.onCreateOptionsMenu(menu, inflater);
	}
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId())
		{
		case R.id.refresh:
			showData();
			break;
			
		case android.R.id.home:
			getActivity().finish();
			break;
		}
		return true;
	}
	
	private void showData() {
		loadingCjjLayout.show_LoadingView();
		mHandler = new Handler();
        mHandler.postDelayed(runnable, 3000);		
	}

	@Override
	public void onDestroyView() {
		
		super.onDestroyView();
	}
	

	private Runnable runnable = new Runnable() {

		@Override
		public void run() {
			loadingCjjLayout.show_EmptyView();
		}

	};

	@Override
	public void onReLoadCallback() {
		
	}
}
