package com.ithm.lotteryhm29.util;

import java.io.IOException;
import java.util.Properties;

public class BeanFactory {
	private static Properties properties;
	static {
		properties = new Properties();
		try {
			properties.load(BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static <T> T getImpl(Class<T> clazz)// 抽象的参数（接口）——UserEngin
	{
		// clazz.getName();// 包名+类名
		String key = clazz.getSimpleName();
		String className = properties.getProperty(key);

		try {
			return (T) Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
