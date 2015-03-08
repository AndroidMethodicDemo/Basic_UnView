package com.demo.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPool {  

//    private static int produceTaskSleepTime = 20;  
      
    private static int produceTaskMaxNumber = 10;  
  
    public static void main(String[] args) {  
  
        // 构造一个线程池  
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(4, 5, 3,  
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1),  
                new ThreadPoolExecutor.DiscardOldestPolicy());  
  
        for (int i = 1; i <= produceTaskMaxNumber; i++) {  
            try {  
                String task = "task@ " + i;  
                System.out.println("创建任务并提交到线程池中：" + task);  
                threadPool.execute(new ThreadPoolTask(task));  
                //-------------
                System.out.println("threadPool.getActiveCount()---"+threadPool.getActiveCount());
                System.out.println("threadPool.getCompletedTaskCount()---"+threadPool.getCompletedTaskCount());
                System.out.println("threadPool.getTaskCount()---"+threadPool.getTaskCount());
                //-------------
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
    }  
} 