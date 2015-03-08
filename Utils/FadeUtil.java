package com.ithm.lotteryhm29.util;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/**
 * 淡入淡出切换
 * 
 * @author l
 * 
 */
public class FadeUtil {
	// 淡入淡出
	// 淡出：正在展示的慢慢退出
	// 获取到正在展示的View
	// 需要执行的时间，在动画完成的时候删除正在展示的View

	// 淡入：淡入的界面需要等待（淡出时间）
	// 淡入的View
	// 淡入执行时间
	
	private static Handler handler=new Handler(){
		public void handleMessage(Message msg) {
			View view=(View) msg.obj;
			ViewGroup parent = (ViewGroup) view.getParent();
			parent.removeView(view);
			
			System.out.println(Thread.currentThread().getName());
		}
	};

	/**
	 * 淡出
	 * 
	 * @param view
	 * @param duration
	 */
	public static void fadeOut(final View view, long duration) {
		// 透明度
		AlphaAnimation animation = new AlphaAnimation(1, 0);
		// 为动画添加监听
		animation.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				// View获取到父容器
//				ViewGroup parent = (ViewGroup) view.getParent();
//				parent.removeView(view);
				System.out.println(Thread.currentThread().getName());
				Message message=Message.obtain();
				message.obj=view;
				handler.sendMessage(message);
				
				// 在2.3模拟器上存在问题
				// 在4.0模拟器上没有问题
				
			}
		});
		
		
		animation.setDuration(duration);
		animation.setFillAfter(true);// 动画停留在执行的终点——属性动画
		view.startAnimation(animation);
		
	}

	/**
	 * 淡入
	 * 
	 * @param view
	 * @param duration
	 * @param delay
	 *            :淡入的界面需要等待（淡出时间）
	 */
	public static void fadeIn(View view, long duration, long delay) {
		AlphaAnimation animation = new AlphaAnimation(0, 1);
		// 延时
		animation.setStartOffset(delay);
		animation.setDuration(duration);
		view.startAnimation(animation);
	}

}
