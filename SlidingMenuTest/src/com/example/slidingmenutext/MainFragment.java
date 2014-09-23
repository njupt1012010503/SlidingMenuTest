package com.example.slidingmenutext;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainFragment extends BaseFragment {
	
	@Override
	public void onInitView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mView=inflater.inflate(R.layout.main_content_fragment, null);
		setTitle(getString(R.string.main));
	}

}
