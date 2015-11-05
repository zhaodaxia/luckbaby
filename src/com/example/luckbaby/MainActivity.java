package com.example.luckbaby;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.example.luckbaby.base.BaseActivity;
import com.example.luckbaby.fragment.Fragment_hy;
import com.example.luckbaby.fragment.Fragment_my;
import com.example.luckbaby.fragment.Fragment_order;
import com.example.luckbaby.fragment.Fragment_sy;

import com.lidroid.xutils.view.annotation.ViewInject;

public class MainActivity extends BaseActivity {
	@ViewInject(R.id.mainfragment_radio)
	private RadioGroup main_radio;
	@ViewInject(R.id.mainfragment_sy_rb)
	private RadioButton mainfragment_sy_rb;

	@ViewInject(R.id.mainfragment_layout_content)
	private FrameLayout mainfragment_layout_content;

	// 碎片管理
	FragmentManager fm;

	private Fragment_sy mFragment_sy;
	private Fragment_hy mFragment_hy;
	private Fragment_order mFragment_order;
	private Fragment_my mFragment_my;

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

	@Override
	public int setLayout() {
		// TODO Auto-generated method stub
		return R.layout.mainactivity;
	}

	@Override
	public void init(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		selsctPage();
		mainfragment_sy_rb.setChecked(true);
	}

	/**
	 * 选择页面
	 */
	private void selsctPage() {
		// TODO Auto-generated method stub
		main_radio.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				fm = getFragmentManager();
				FragmentTransaction transaction = fm.beginTransaction();
				//隐藏碎片
				hideFragments(transaction);
				switch (checkedId) {
				case R.id.mainfragment_sy_rb:
					if (mFragment_sy == null) {
						mFragment_sy = new Fragment_sy();
						transaction.add(R.id.mainfragment_layout_content, mFragment_sy);
					} else {
						transaction.show(mFragment_sy);
					}
					break;
				case R.id.mainfragment_hy_rb:
					if (mFragment_hy == null) {
						mFragment_hy = new Fragment_hy();
						transaction.add(R.id.mainfragment_layout_content, mFragment_hy);
					} else {
						transaction.show(mFragment_hy);
					}
					break;
				case R.id.mainfragment_order_rb:
					if (mFragment_order == null) {
						mFragment_order = new Fragment_order();
						transaction.add(R.id.mainfragment_layout_content, mFragment_order);
					} else {
						transaction.show(mFragment_order);
					}
					break;
				case R.id.mainfragment_my_rb:
					if (mFragment_my == null) {
						mFragment_my = new Fragment_my();
						transaction.add(R.id.mainfragment_layout_content, mFragment_my);
					} else {
						transaction.show(mFragment_my);
					}
					break;
				}
				transaction.commit();
			}
		});
	}

	protected void hideFragments(FragmentTransaction transaction) {
		// TODO Auto-generated method stub
		if (mFragment_sy != null) {
			transaction.hide(mFragment_sy);
		}
		if (mFragment_hy != null) {
			transaction.hide(mFragment_hy);
		}
		if (mFragment_order != null) {
			transaction.hide(mFragment_order);
		}
		if (mFragment_my != null) {
			transaction.hide(mFragment_my);
		}
	}

	@Override
	public void setListener() {
		// TODO Auto-generated method stub

	}

}
