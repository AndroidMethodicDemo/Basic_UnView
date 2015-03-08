package com.example.proguard.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.proguard.R;
import com.example.proguard.biz.BIZ_News;

public class ACT_Main extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_main);
		TextView title=(TextView) findViewById(R.id.title);
		title.setText(BIZ_News.getNews().getTitle());
	}
}
