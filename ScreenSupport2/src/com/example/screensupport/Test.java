package com.example.screensupport;

import android.test.AndroidTestCase;

public class Test extends AndroidTestCase {

	public void printScreenInfo(){
		MO_ScreenInfo.screenInfo(getContext());
	}
}
