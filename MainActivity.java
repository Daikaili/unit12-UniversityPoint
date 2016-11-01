package com.example.point.activity;

import com.example.point.R;
import com.example.point.R.id;
import com.example.point.R.layout;
import com.example.point.R.menu;
import com.example.point.campuslife.LifeActivity;
import com.example.point.go.GoActivity;
import com.example.point.phone.PhoneActivity;
import com.example.point.play.PlayActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
   private Button btnLife,btnGo,btnPlay,btnPhone;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		buttonInit();
		//���пؼ���ʼ��
		setOnClickListener();
		//�ؼ��ļ���
	}

	private void setOnClickListener() {

		// TODO Auto-generated method stub
		MyOnClickListener myOnClickListener=new MyOnClickListener();
		btnLife.setOnClickListener(myOnClickListener);
		btnGo.setOnClickListener(myOnClickListener);
		btnPlay.setOnClickListener(myOnClickListener);
		btnPhone.setOnClickListener(myOnClickListener);
		
	}//Ϊ��ť����¼�������

	private void buttonInit() {

		// TODO Auto-generated method stub
		btnLife=(Button) this.findViewById(R.id.btnLife);
		btnGo=(Button) this.findViewById(R.id.btnGo);
		btnPlay=(Button) this.findViewById(R.id.btnPlay);
		btnPhone=(Button) this.findViewById(R.id.btnPhone);
	}//����ID�ҵ��ؼ�
	public class MyOnClickListener implements OnClickListener{
		Intent intent=null;
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.btnPhone:
				intent=new Intent(MainActivity.this,PhoneActivity.class);
				break;
				//��ת��"�������ͨ"
			case R.id.btnGo:
				intent=new Intent(MainActivity.this,GoActivity.class);
				break;
				//��ת��"����ָ��"
			case R.id.btnLife:
				intent=new Intent(MainActivity.this,LifeActivity.class);
				break;
				//��ת��"У԰����"	
			
			case R.id.btnPlay:
			intent=new Intent(MainActivity.this,PlayActivity.class);
			break;
			//��ת��"�����ϲ�"
			default:break;
			}
			startActivity(intent);
		}

	}
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {


		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
		}

