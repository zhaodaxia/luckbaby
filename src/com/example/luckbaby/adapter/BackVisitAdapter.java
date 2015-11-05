package com.example.luckbaby.adapter;

import com.example.luckbaby.R;
import com.example.luckbaby.adapter.GridviewAdapter.ViewHolder;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BackVisitAdapter extends BaseAdapter {
	private String[] names1 = { "张嘉译", "李梦龙", "李鼎坤", "周利娟", "李雪茹",
			"李梦婷"};
	private String[] names2 = { "张嘉译", "张嘉译", "张嘉译", "张嘉译", "张嘉译",
			"张嘉译"};
	private String[] phonenumber = { "13601243245", "18541355234", "18933456788", "13675844902", "18555677831",
			"13823484572"};
	private String[] history1 = { "生日", "生日", "周期", "周期", "生日","周期" };
	private String[] history2 = { "已回访", "拒绝回访", "已回访", "已回访", "已回访","拒绝回访" };
	
	private Context context;
	private int flag;
	public BackVisitAdapter(Context context,int flag) {
		super();
		this.context = context;
		this.flag = flag;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return names1.length;
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
					R.layout.backvisit_item, null);
			holder = new ViewHolder();
			holder.tv1 = (TextView) convertView.findViewById(R.id.textView1);
			holder.tv2 = (TextView) convertView.findViewById(R.id.textView2);
			holder.tv3 = (TextView) convertView.findViewById(R.id.textView3);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		if(flag==0){
			holder.tv1.setText(names1[position]);
			holder.tv2.setText(phonenumber[position]);
			holder.tv3.setText(history1[position]);
		}else{
			holder.tv1.setText(names2[position]);
			holder.tv2.setText(phonenumber[position]);
			holder.tv3.setText(history2[position]);
			if(history2[position].equals("拒绝回访")){
				holder.tv3.setTextColor(0xFFFF0000);
			}
		}
		return convertView;
	}
	
	class ViewHolder {
		TextView tv1;
		TextView tv2;
		TextView tv3;
	}

}
