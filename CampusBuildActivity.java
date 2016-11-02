package com.example.point.campuslife;

import com.example.point.R;
import com.example.point.R.layout;
import com.example.point.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
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
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_campus_build);
		
		mySpinner=(Spinner) this.findViewById(R.id.mySpinner);
		myImage=(ImageView) this.findViewById(R.id.myImage);
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
			}
		});
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.campus_build, menu);
		return true;
	}

}
