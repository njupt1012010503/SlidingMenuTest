package com.example.slidingmenutext;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;



public class MainActivity extends SlidingFragmentActivity implements OnClickListener{
	private SlidingMenu slidingMenu;
	private Fragment mFrag;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setBehindContentView(R.layout.slidingmenu_left);//提供一个空的FrameLayout用来存放菜单Fragment
		
		if (savedInstanceState == null) {
			FragmentTransaction t = this.getSupportFragmentManager().beginTransaction();
			mFrag = new LeftFragment();//具体菜单样式，用户可以在这里自定义自己的菜单
			t.replace(R.id.menu_frame, mFrag);
			t.commit();
		} else {
			mFrag = (Fragment)this.getSupportFragmentManager().findFragmentById(R.id.menu_frame);
		}
		
		//这里设置SlidingMenu的一些属性
		slidingMenu=getSlidingMenu();
		slidingMenu.setMode(SlidingMenu.LEFT);// 设置是左滑还是右滑，还是左右都可以滑，我这里只做了左滑
		slidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);// 设置菜单宽度
		slidingMenu.setFadeDegree(0.35f);// 设置淡入淡出的比例
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);//设置手势模式
		slidingMenu.setShadowDrawable(R.drawable.shadow);// 设置左菜单阴影图片
		slidingMenu.setFadeEnabled(true);// 设置滑动时菜单的是否淡入淡出
		slidingMenu.setBehindScrollScale(0.333f);// 设置滑动时拖拽效果
		
		setContentView(R.layout.slidingmenu_center);//提供一个空的FrameLayout用来存放中间内容的fragment
		
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.content_frame, new MainFragment())//替换中间显示的fragment
		.commit();
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		default:
			break;
		}
		
	}

	public void swtichFragment(Fragment newFragment) {
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.content_frame, newFragment)
		.commit();
		getSlidingMenu().showContent();
	}
	
	

}
