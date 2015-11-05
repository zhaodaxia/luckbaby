package com.example.luckbaby.activity.backvisit;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.example.luckbaby.R;
import com.example.luckbaby.adapter.BackVisitAdapter;
import com.example.luckbaby.base.BaseActivity;
import com.lidroid.xutils.view.annotation.ViewInject;

public class BackvisitActivity extends BaseActivity {
	//RadioGroup所用数据
	@ViewInject(R.id.backvisit_radioGroup1)
	private RadioGroup backvisit_radioGroup1;
	@ViewInject(R.id.backvisit_rb_today)
	private RadioButton backvisit_rb_today;
	
	//下面的线
	@ViewInject(R.id.backvisit_today_line)
	private ImageView backvisit_today_line;
	@ViewInject(R.id.backvisit_history_line)
	private ImageView backvisit_history_line;
	//private int SETLINEVISIBILIT = 0;
	
	//listview所用数据
	@ViewInject(R.id.backvisit_listView)
	private ListView backvisit_listView;
	private BackVisitAdapter mBackVisitAdapter;
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

	@Override
	public int setLayout() {
		// TODO Auto-generated method stub
		return R.layout.backvisit;
	}

	@Override
	public void init(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//首次进入时
		backvisit_rb_today.setChecked(true);
		mBackVisitAdapter = new BackVisitAdapter(BackvisitActivity.this, 0);
		backvisit_listView.setAdapter(mBackVisitAdapter);
		backvisit_today_line.setVisibility(View.VISIBLE);
		backvisit_history_line.setVisibility(View.INVISIBLE);
		initListview();
		
	}

	private void initListview() {
		// TODO Auto-generated method stub
		backvisit_radioGroup1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				switch (checkedId) {
				case R.id.backvisit_rb_today:
					mBackVisitAdapter = new BackVisitAdapter(BackvisitActivity.this, 0);
					backvisit_listView.setAdapter(mBackVisitAdapter);
					backvisit_today_line.setVisibility(View.VISIBLE);
					backvisit_history_line.setVisibility(View.INVISIBLE);
					break;
				case R.id.backvisit_rb_history:
					mBackVisitAdapter = new BackVisitAdapter(BackvisitActivity.this, 1);
					backvisit_listView.setAdapter(mBackVisitAdapter);
					backvisit_today_line.setVisibility(View.INVISIBLE);
					backvisit_history_line.setVisibility(View.VISIBLE);
					break;

				default:
					break;
				}
			}
		});
		
		
	}

	@Override
	public void setListener() {
		// TODO Auto-generated method stub

	}

}
