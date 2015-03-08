package com.example.proguard.biz;

import java.util.List;

import com.example.proguard.bean.News;

public class BIZ_News {

	public static List<News> getNewsList(){
		return null;
	}
	public static News getNews(){
		News news = new News();
		news.setTitle("两岸中小企业寿命相差超9年");
		return news;
	}
	
}
