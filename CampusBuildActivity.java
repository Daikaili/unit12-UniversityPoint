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
	//ͼƬID����
	String[]xiaoqv=new String[]{
			"��ͨʾ��ͼ","����У��","��®У��","����У��"};
	//�б�����
	private Spinner mySpinner;
	private ImageView myImage;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_campus_build);
		
		mySpinner=(Spinner) this.findViewById(R.id.mySpinner);
		myImage=(ImageView) this.findViewById(R.id.myImage);
		//����IDѰ�ҵ�Spinner��ImageView
		ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line,xiaoqv);
		//������ʽ������
		mySpinner.setAdapter(adapter);
		//ΪSpinner����Adapter
		mySpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
        //ѡ���¼�����
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long id) {
				// TODO Auto-generated method stub
				myImage.setImageResource(imageIds[position]);
				//����ѡ����ʾͼƬ
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
