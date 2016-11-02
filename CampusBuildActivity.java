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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class CampusBuildActivity extends Activity {

	int[] imageIds=new int[]{
			R.drawable.c,R.drawable.b,R.drawable.a,R.drawable.e};
	//图片ID数组
	String[]xiaoqv=new String[]{
			"交通示意图","蛟桥校区","麦庐校区","枫林校区"};
	//列表内容
	private Spinner mySpinner;
	private ImageView myImage;
	private Button btnReturn1,btnReturn2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_campus_build);
		
		mySpinner=(Spinner) this.findViewById(R.id.mySpinner);
		myImage=(ImageView) this.findViewById(R.id.myImage);
		btnReturn1=(Button) this.findViewById(R.id.btnReturn1);
		btnReturn2=(Button) this.findViewById(R.id.btnReturn2);
		setOnClickListener();
		//控件的监听
		
		//根据ID寻找到Spinner和ImageView
		ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line,xiaoqv);
		//设置样式和内容
		mySpinner.setAdapter(adapter);
		//为Spinner设置Adapter
		mySpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
        //选中事件监听
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long id) {
				// TODO Auto-generated method stub
				myImage.setImageResource(imageIds[position]);
				//根据选择显示图片
			}
			

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				myImage.setImageResource(imageIds[0]);
				//默认显示第一张图片
			}
		});
		
		//图片的触摸事件
		myImage.setOnTouchListener(new OnTouchListener() {
			//匿名内部类实现触摸事件监听器
			float mx,my;
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				float curX,curY;
				//触摸事件发生的坐标
				switch(event.getAction()){
				case MotionEvent.ACTION_DOWN:
			         mx = event.getX();
					 my=event.getY();
					break;
				case MotionEvent.ACTION_MOVE:
				   curX = event.getX();
				   curY=event.getY();
				   myImage.scrollBy((int)(mx-curX),(int)(my-curY));
				   mx=curX;
				   my=curY;
				   break;
				case MotionEvent.ACTION_UP:
					 curX = event.getX();
					  curY=event.getY();
					  myImage.scrollBy((int)(mx-curX),(int)(my-curY));
					  break;
			   default:
				   break;
				}
				return true;
			}
		});
		
		
		}

	private void setOnClickListener() {
		// TODO Auto-generated method stub
		MyOnClickListener myOnClickListener=new MyOnClickListener();
		btnReturn1.setOnClickListener(myOnClickListener);
		btnReturn2.setOnClickListener(myOnClickListener);
	}
	public class MyOnClickListener implements OnClickListener{
	 	Intent intent=null;
	 	@Override
			public void onClick(View v) {
			// TODO Auto-generated method stub
				switch(v.getId()){
	 		case R.id.btnReturn1:
					intent=new Intent(CampusBuildActivity.this,PhoneActivity.class);
					break;
	 				//跳转到首页
	 			case R.id.btnReturn2:
	 				intent=new Intent(CampusBuildActivity.this,GoActivity.class);
	 			break;
	 				//跳转到"学校生活"
	 			
	 			default:break;
	 			}
	 			startActivity(intent);
	 		}

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.campus_build, menu);
		return true;
	}

}
