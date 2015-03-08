package com.demo.thread;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;

public class ThreadPoolTask implements Runnable, Serializable {  
	  
    private Object attachData;  
  
    ThreadPoolTask(Object tasks) {  
        this.attachData = tasks;  
    }  
  
    public void run() {  
          
        System.out.println("开始执行任务：" + attachData);  
        ThreadPoolTask.download(attachData);
          System.out.println("任务执行完成：" + attachData);  
        attachData = null;  
    }  
  
    public Object getTask() {  
        return this.attachData;  
    }  
    
    /**
     * 使用get的方式登录
     * @param userName
     * @param password
     * @return 登录的状态
     */
    public static void download(Object attachData) {
        HttpURLConnection conn = null;
        try {
//            String data = "username=" + URLEncoder.encode(userName) + "&password=" + URLEncoder.encode(password);
            URL url = new URL("http://resget.91.com/Soft/Controller.ashx?action=download&tpl=1&id=41013415" );
            conn = (HttpURLConnection) url.openConnection();
            
            conn.setRequestMethod("GET");        // get或者post必须得全大写
            conn.setConnectTimeout(10000); // 连接的超时时间
            conn.setReadTimeout(5000); // 读数据的超时时间
            
            int responseCode = conn.getResponseCode();
            if(responseCode == 200) {
                InputStream is = conn.getInputStream();
                ThreadPoolTask.copyFile(is, new File("/home/tony/下载/apk_"+attachData+"_"+Thread.currentThread().getId()));
//                String state = getStringFromInputStream(is);
//                return state;
            } else {
                System.out.println(responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(conn != null) {
                conn.disconnect();        // 关闭连接
            }
        }
//        return null;
    }
    // 复制文件
    public static void copyFile(InputStream in, File targetFile) throws IOException {
        BufferedInputStream inBuff = null;
        BufferedOutputStream outBuff = null;
        try {
            // 新建文件输入流并对它进行缓冲
//            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));
            inBuff=new BufferedInputStream(in);

            // 新建文件输出流并对它进行缓冲
            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

            // 缓冲数组
            byte[] b = new byte[1024 * 5];
            int len;
            while ((len = inBuff.read(b)) != -1) {
                outBuff.write(b, 0, len);
            }
            // 刷新此缓冲的输出流
            outBuff.flush();
        } finally {
            // 关闭流
            if (inBuff != null)
                inBuff.close();
            if (outBuff != null)
                outBuff.close();
        }
    }
    /**
     * 根据流返回一个字符串信息
     * @param is
     * @return
     * @throws IOException 
     */
    public static String getStringFromInputStream(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        
        while((len = is.read(buffer)) != -1) {
            baos.write(buffer, 0, len);
        }
        is.close();
        
        String html = baos.toString();    // 把流中的数据转换成字符串, 采用的编码是: utf-8
        
//        String html = new String(baos.toByteArray(), "GBK");
        
        baos.close();
        return html;
    }
}  
