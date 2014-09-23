package com.example.slidingmenutext;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;


public class SoftwareUpdateFragment extends BaseFragment {

	@Override
	public void onInitView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mView=inflater.inflate(R.layout.software_update_fragment, null);
		setTitle(getString(R.string.software_update));
	}
	
	
}
