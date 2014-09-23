package com.example.slidingmenutext;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;


public class AboutFragment extends BaseFragment {

	@Override
	public void onInitView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mView=inflater.inflate(R.layout.about_fragment, null);
		setTitle(getString(R.string.about));
	}
	
	

}
