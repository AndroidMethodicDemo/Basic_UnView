package com.example.screensupport;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;

public class MO_ScreenInfo {

	/**
	 * 联想pad：density=1.0, dpi=160, widthpx=752, heightpx=1280, xdpi=160.15764, ydpi=160.0
	 * dpi=320, widthpx=1280, heightpx=720
	 */
	public static void screenInfo(Context context) {
		DisplayMetrics displayMetrics = context.getResources()
				.getDisplayMetrics();
		// 密度（像素长宽与物理长宽算出来的一个值）
		float density = displayMetrics.density;
		// dpi
		int dpi = displayMetrics.densityDpi;
		// 像素宽度
		int widthpx = displayMetrics.heightPixels;
		// 像素高度
		int heightpx = displayMetrics.widthPixels;
		// x维度上每英寸像素值
		float xdpi = displayMetrics.xdpi;
		// y维度上每英寸像素值
		float ydpi = displayMetrics.ydpi;
		Log.d("DPI", "density=" + density + ", dpi=" + dpi + ", widthpx="
				+ widthpx + ", heightpx=" + heightpx + ", xdpi=" + xdpi
				+ ", ydpi=" + ydpi);

	}
}
