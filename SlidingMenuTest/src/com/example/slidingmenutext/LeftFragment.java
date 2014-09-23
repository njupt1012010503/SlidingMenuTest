package com.example.slidingmenutext;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class LeftFragment extends Fragment implements OnClickListener{
	private View mainBtnLayout;
	private View softwareUpdateBtnLayout;
	private View commentBackBtnLayout;
	private View aboutBtnLayout;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.left_menu_fragment, null);
		mainBtnLayout=view.findViewById(R.id.main_btn_layout);
		mainBtnLayout.setOnClickListener(this);
		softwareUpdateBtnLayout=view.findViewById(R.id.software_update_btn_layout);
		softwareUpdateBtnLayout.setOnClickListener(this);
		commentBackBtnLayout=view.findViewById(R.id.comment_back_btn_layout);
		commentBackBtnLayout.setOnClickListener(this);
		aboutBtnLayout=view.findViewById(R.id.about_btn_layout);
		aboutBtnLayout.setOnClickListener(this);
		
		//Ä¬ÈÏ×´Ì¬
		mainBtnLayout.setSelected(true);
		softwareUpdateBtnLayout.setSelected(false);
		commentBackBtnLayout.setSelected(false);
		aboutBtnLayout.setSelected(false);
		
		return view;

	}

	@Override
	public void onClick(View v) {
		Fragment newFragment=null;
		switch (v.getId()) {
		case R.id.main_btn_layout:
			newFragment=new MainFragment();
			mainBtnLayout.setSelected(true);
			softwareUpdateBtnLayout.setSelected(false);
			commentBackBtnLayout.setSelected(false);
			aboutBtnLayout.setSelected(false);
			break;
		case R.id.software_update_btn_layout:
			newFragment=new SoftwareUpdateFragment();
			mainBtnLayout.setSelected(false);
			softwareUpdateBtnLayout.setSelected(true);
			commentBackBtnLayout.setSelected(false);
			aboutBtnLayout.setSelected(false);
			break;
		case R.id.comment_back_btn_layout:
			newFragment=new CommentBackFragment();
			mainBtnLayout.setSelected(false);
			softwareUpdateBtnLayout.setSelected(false);
			commentBackBtnLayout.setSelected(true);
			aboutBtnLayout.setSelected(false);
			break;
		case R.id.about_btn_layout:
		    newFragment=new AboutFragment();
		    mainBtnLayout.setSelected(false);
		    softwareUpdateBtnLayout.setSelected(false);
			commentBackBtnLayout.setSelected(false);
			aboutBtnLayout.setSelected(true);
		    break;
		default:
			break;
		}
		
		if(newFragment!=null)
			switchFragment(newFragment);
	}

	private void switchFragment(Fragment newFragment) {
		MainActivity main=(MainActivity) getActivity();
		main.swtichFragment(newFragment);
	}

}
