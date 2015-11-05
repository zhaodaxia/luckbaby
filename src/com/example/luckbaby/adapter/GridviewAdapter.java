package com.example.luckbaby.adapter;

import com.example.luckbaby.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridviewAdapter extends BaseAdapter {

	// 参数
	private int[] images = { R.drawable.sy_36, R.drawable.sy_38,
			R.drawable.sy_41, R.drawable.sy_43, R.drawable.sy_50,
			R.drawable.sy_52, R.drawable.sy_53, R.drawable.sy_54 };
	private String[] strings = { "今日回访", "订单处理", "代客下单", "商品管理", "营销中心",
			"会员统计", "订单统计", "结算中心" };

	private Context context;

	public GridviewAdapter() {
		super();
	}

	public GridviewAdapter(Context context) {
		super();
		this.context = context;
		Log.i("tag", "进入适配器");
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return images.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;

		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.gridview_item, null);

			holder = new ViewHolder();
			holder.iv = (ImageView) convertView.findViewById(R.id.imageView1);
			holder.tv = (TextView) convertView.findViewById(R.id.textView1);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.iv.setImageResource(images[position]);
		holder.tv.setText(strings[position]);
		return convertView;
	}

	class ViewHolder {
		ImageView iv;
		TextView tv;
	}
}
