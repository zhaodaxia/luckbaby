package com.example.luckbaby.activity.login;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.luckbaby.R;
import com.example.luckbaby.MainActivity;
import com.example.luckbaby.base.BaseActivity;
import com.example.luckbaby.utils.ToastUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class LoginActivity extends BaseActivity {
	private Intent intent;
	
	//新用户注册
	@ViewInject(R.id.login_new_zc)
	private LinearLayout login_new_zc;
	
	//忘记密码
	@ViewInject(R.id.login_forget)
	private LinearLayout login_forget;
	
	//电话号码
	@ViewInject(R.id.login_phonenumben_et)
	private EditText login_phonenumben_et;
	
	//密码
	@ViewInject(R.id.login_password_tv)
	private EditText login_password_tv;
	
	//登陆
	@ViewInject(R.id.login_bt)
	private Button login_bt;
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

	@Override
	public int setLayout() {
		// TODO Auto-generated method stub
		return R.layout.login;
	}

	@Override
	public void init(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		LostPWD();
		Register();
		
		login_bt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String user = login_phonenumben_et.getText().toString();
				String pwd = login_password_tv.getText().toString();
				if (TextUtils.isEmpty(user)) {
					Toast.makeText(getApplicationContext(), "请输入您的用户名", 0).show();
				} else if (TextUtils.isEmpty(pwd)) {
					Toast.makeText(getApplicationContext(), "请输入您的密码", 0).show();
				} else {
					// TODO 把用户名密码发往服务器端验证，分成功和失败两种情况
					login(user, pwd);
					ToastUtils.show(LoginActivity.this, "后台请求数据");
					intent = new Intent(LoginActivity.this, MainActivity.class);
					startActivity(intent);
					finish();
				}
			}
		});
	}
	
	protected void login(String user, String pwd) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 注册
	 */
	private void Register() {
		// TODO Auto-generated method stub
		login_new_zc.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				intent = new Intent(LoginActivity.this, RegisterActivity.class);
				startActivity(intent);
			}
		});
	}
	
	/**
	 * 忘记密码
	 */
	private void LostPWD() {
		// TODO Auto-generated method stub
		login_forget.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				intent = new Intent(LoginActivity.this, ForgetPasswordActivity.class);
				startActivity(intent);
			}
		});
	}
	
	@Override
	public void setListener() {
		// TODO Auto-generated method stub
		
	}

}
