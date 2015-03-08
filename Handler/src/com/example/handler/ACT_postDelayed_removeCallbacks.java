package com.example.handler;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ACT_postDelayed_removeCallbacks extends Activity{

        private Button button1;  
        private Button button2;  
        private TextView text;
     
        private Handler handler = new Handler();  
     
        private int count = 0;  
     
        private Runnable runnableRef = new Runnable() {  
            public void run() {  
                Log.v("2", Thread.currentThread().getName());  
                count++;  
                Log.v("!", "count=" + count);  
                text.setText(count+"");
                handler.postDelayed(runnableRef, 1000);  
            }  
        };  
     
        @Override  
        public void onCreate(Bundle savedInstanceState) {  
            super.onCreate(savedInstanceState);  
            setContentView(R.layout.act_postdelayed_removecallbacks);  
     
            Log.v("1", Thread.currentThread().getName());  
     
            button1 = (Button) this.findViewById(R.id.button1);  
            button2 = (Button) this.findViewById(R.id.button2);  
            text = (TextView) this.findViewById(R.id.text);  
     
            button1.setOnClickListener(new OnClickListener() {  
                public void onClick(View arg0) {  
//                    Thread thread = new Thread(runnableRef);  
//                    thread.start();  
                    handler.post(runnableRef);
                    Log.v("!!!!!!!!!!!!!", "end");  
                }  
            });  
     
            button2.setOnClickListener(new OnClickListener() {  
                public void onClick(View arg0) {  
                    handler.removeCallbacks(runnableRef);  
                }  
            });  
     
        }  
}
