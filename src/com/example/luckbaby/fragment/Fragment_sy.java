package com.example.luckbaby.fragment;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.example.luckbaby.R;
import com.example.luckbaby.activity.agentorder.AgentOrderActivity;
import com.example.luckbaby.activity.backvisit.BackvisitActivity;
import com.example.luckbaby.activity.commoditymanagement.CommodityManagementActivity;
import com.example.luckbaby.activity.marketingcenter.MarketingCenterActivity;
import com.example.luckbaby.activity.memberstatistics.MemberStatisticsActivity;
import com.example.luckbaby.activity.order.OrderActivity;
import com.example.luckbaby.activity.orderstatistics.OrderStatisticsActivity;
import com.example.luckbaby.activity.settlementcenter.SettlementCenterActivity;
import com.example.luckbaby.adapter.GridviewAdapter;
import com.example.luckbaby.base.BaseFragment;
import com.example.luckbaby.utils.YangUtils;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class Fragment_sy extends BaseFragment {
	private Intent intent;
	@ViewInject(R.id.fragment_sy_vp)
	private ViewPager fragment_sy_vp;// 轮播图
	@ViewInject(R.id.fragment_sy_point)
	private LinearLayout fragment_sy_point;// 轮播点

	// gridview
	@ViewInject(R.id.fragment_sy_gridview)
	private GridView fragment_sy_gridview;
	private GridviewAdapter gvAdapter;

	private List<View> views = new ArrayList<View>();
	private int[] images = { R.drawable.sy, R.drawable.sy, R.drawable.sy,
			R.drawable.sy };
	private int currentItem = 0;
	private boolean flag = true;
	private LayoutParams paramsL = new LayoutParams(20, 20);

	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			currentItem = fragment_sy_vp.getCurrentItem() + 1;
			fragment_sy_vp.setCurrentItem(currentItem);
		}

	};

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

	@Override
	public View initView(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		view = View.inflate(context, R.layout.fragment_sy, null);
		ViewUtils.inject(this, view);
		// 初始化vp
		initVp();
		// 初始化gridview
		initGridview();
		// 二维码
		goQR();
		// 消息中心
		goMessage();

		return view;
	}

	private void initGridview() {
		// TODO Auto-generated method stub
		gvAdapter = new GridviewAdapter(getActivity());
		fragment_sy_gridview.setAdapter(gvAdapter);
		fragment_sy_gridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				switch (position) {
				case 0:
					intent = new Intent(getActivity(), BackvisitActivity.class);
					startActivity(intent);
					break;
				case 1:
					intent = new Intent(getActivity(), OrderActivity.class);
					startActivity(intent);
					break;
				case 2:
					intent = new Intent(getActivity(), AgentOrderActivity.class);
					startActivity(intent);
					break;
				case 3:
					intent = new Intent(getActivity(), CommodityManagementActivity.class);
					startActivity(intent);
					break;
				case 4:
					intent = new Intent(getActivity(), MarketingCenterActivity.class);
					startActivity(intent);
					break;
				case 5:
					intent = new Intent(getActivity(), MemberStatisticsActivity.class);
					startActivity(intent);
					break;
				case 6:
					intent = new Intent(getActivity(), OrderStatisticsActivity.class);
					startActivity(intent);
					break;
				case 7:
					intent = new Intent(getActivity(), SettlementCenterActivity.class);
					startActivity(intent);
					break;

				default:
					break;
				}
			}
		});
	}

	private void initVp() {
		// TODO Auto-generated method stub
		fragment_sy_vp.setAdapter(new MyPageAdapter());
		currentItem = Integer.MAX_VALUE / 2 - Integer.MAX_VALUE / 2
				% images.length;
		fragment_sy_vp.setCurrentItem(currentItem);

		initPoint();
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (flag) {
					try {
						Thread.sleep(3000);
						handler.sendEmptyMessage(0);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}

			}
		}).start();
	}

	/**
	 * 初始化点
	 */
	private void initPoint() {

		for (int i = 0; i < images.length; i++) {
			View view = new View(getActivity());
			paramsL.setMargins(YangUtils.dip2px(getActivity(), 5), 0, 0, 0);
			view.setLayoutParams(paramsL);
			if (i == 0) {
				view.setBackgroundResource(R.drawable.xl_03);
			} else {
				view.setBackgroundResource(R.drawable.xl_05);
			}

			views.add(view);
			fragment_sy_point.addView(view);
		}

	}

	// 右上角
	private void goMessage() {
		// TODO Auto-generated method stub

	}

	// 左上角二维码
	private void goQR() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initData(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setListener() {
		// TODO Auto-generated method stub

		fragment_sy_vp.setOnPageChangeListener(new OnPageChangeListener() {
			public void onPageSelected(int position) {
				if (views.size() != 0
						&& views.get(position % images.length) != null) {

					for (int i = 0; i < views.size(); i++) {
						if (i == position % images.length) {
							views.get(i)
									.setBackgroundResource(R.drawable.xl_03);
						} else {
							views.get(i)
									.setBackgroundResource(R.drawable.xl_05);
						}
					}

				}
			}

			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			public void onPageScrollStateChanged(int arg0) {

			}
		});
	}

	@Override
	public void onDestroy() {
		flag = false;
		super.onDestroy();
	}

	private class MyPageAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return Integer.MAX_VALUE;
		}

		public void destroyItem(ViewGroup container, int position, Object object) {
			((ViewPager) container).removeView((View) object);
		}

		public Object instantiateItem(ViewGroup container, final int position) {
			int index = position % images.length;
			View view = View
					.inflate(getActivity(), R.layout.home_vp_item, null);

			ImageView iv_iamge = (ImageView) view.findViewById(R.id.iv_image);
			iv_iamge.setBackgroundResource(images[index]);

			((ViewPager) container).addView(view);

			iv_iamge.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {

				}
			});

			return view;
		}

		public boolean isViewFromObject(View view, Object obj) {
			return view == obj;
		}

	}

}
