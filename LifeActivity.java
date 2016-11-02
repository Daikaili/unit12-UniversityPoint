package com.example.point.campuslife;

import com.example.point.R;
import com.example.point.R.layout;
import com.example.point.R.menu;
import com.example.point.activity.MainActivity;
import com.example.point.activity.MainActivity.MyOnClickListener;
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

public class LifeActivity extends Activity {
   private Button btnPingmian,btnSlight,btnNew,btnReturn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_life);
		buttonInit();
		//���пؼ���ʼ��
		setOnClickListener();
		//�ؼ��ļ���
	}

	private void setOnClickListener() {
		// TODO Auto-generated method stub
		MyOnClickListener myOnClickListener=new MyOnClickListener();
		btnPingmian.setOnClickListener(myOnClickListener);
		btnSlight.setOnClickListener(myOnClickListener);
		btnNew.setOnClickListener(myOnClickListener);
		btnReturn.setOnClickListener(myOnClickListener);
	}

	private void buttonInit() {
		// TODO Auto-generated method stub
		btnPingmian=(Button) this.findViewById(R.id.btnPingmian);
		btnSlight=(Button) this.findViewById(R.id.btnSlight);
		btnNew=(Button) this.findViewById(R.id.btnNew);
		btnReturn=(Button) this.findViewById(R.id.btnReturn);
	}
	public class MyOnClickListener implements OnClickListener{
	 	Intent intent=null;
	 	@Override
			public void onClick(View v) {
			// TODO Auto-generated method stub
				switch(v.getId()){
	 		case R.id.btnPingmian:
					intent=new Intent(LifeActivity.this,CampusBuildActivity.class);
					break;
	 				//��ת��"У԰ƽ��ͼ"
	 			case R.id.btnSlight:
	 				intent=new Intent(LifeActivity.this,CampusSceneryActivity.class);
	 			break;
	 				//��ת��"У԰�羰"
	 			case R.id.btnNew:
	 				intent=new Intent(LifeActivity.this,FreshAssistActivity.class);
	 			break;
	 				//��ת��"����ָ����Ϣ"	
	 			
	 			case R.id.btnReturn:
	 		        intent=new Intent(LifeActivity.this,MainActivity.class);
	 			break;
	 			//��ת��"��ҳ��"
	 			default:break;
	 			}
	 			startActivity(intent);
	 		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.life, menu);
		return true;
	}

}
