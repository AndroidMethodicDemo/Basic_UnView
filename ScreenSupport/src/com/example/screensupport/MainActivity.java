package com.example.screensupport;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		float density = getResources().getDisplayMetrics().density;

		int dpi = getResources().getDisplayMetrics().densityDpi;

		int widthpx = getResources().getDisplayMetrics().heightPixels;

		int heightpx = getResources().getDisplayMetrics().widthPixels;

		Log.d("DPI", "density=" + density + ", dpi=" + dpi + ", widthpx=" + widthpx + ", heightpx=" + heightpx);
	}

}
