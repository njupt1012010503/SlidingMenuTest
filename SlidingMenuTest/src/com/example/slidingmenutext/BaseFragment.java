package com.example.slidingmenutext;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Fragment 的模板类（这里用到了设计中的模板模式，使得子类可以不改变一个算法的结构即可重新定义该算法的某些特定步骤）
 * @author yixiang
 *
 */
public abstract class BaseFragment extends Fragment implements OnClickListener{
	public View mView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		container.removeAllViews();
		try {
			onInitView(inflater, container, savedInstanceState);
			setTopLeftButton(R.drawable.menu_icon);
		} catch (OutOfMemoryError e) {
			System.gc();
			System.runFinalization();
			return super.onCreateView(inflater, container, savedInstanceState);
		}
	
		return mView;
	}
	
	//子类必须实现的该方法
	public abstract void onInitView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState);
	
	/**
	 * 设置标题
	 * @param title
	 */
	public void setTitle(String title) {
		TextView titleView = (TextView) mView.findViewById(R.id.title);
		titleView.setText(title);
	}
	
	/**
	 * 设置顶部左按钮
	 * @param iconId
	 */
	public void setTopLeftButton(int iconId) {
		ImageButton button = (ImageButton) mView.findViewById(R.id.left_button);
		button.setImageResource(iconId);
		button.setOnClickListener(this);
	}
	
	
	/**
	 *  左按钮点击事件
	 */
	public void leftButtonOnClick() {
		MainActivity m=(MainActivity) getActivity();
		m.toggle();
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.left_button:
			leftButtonOnClick();
			break;
		default:
			break;
		}
	}
	

}
