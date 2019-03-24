package com.webServerBySocketForDifferentPath.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// 用于读取properties配置文件
public class PropertiesUtil {

	// properties文件路径
	private static final String propertiesPath = System.getProperty("user.dir") + "\\src\\com\\webServerBySocketForDifferentPath\\config";
	private static Properties properties = new Properties();
	
	// 返回key对应的html文件路径
	public static String getHtmlPathByProperties(String fileName, String key) {
		
		readProperties(fileName);
		return System.getProperty("user.dir") + properties.getProperty(key);
	}
	
	// 根据key读取properties文件value
	public static String getPropertiesByKey(String fileName, String key) {
		
		readProperties(fileName);
		return properties.getProperty(key);
	}
	
	// 输入properties文件名称，到\src\config路径下读取文件
	private static void readProperties(String fileName) {
		
		try {
			FileInputStream fis = new FileInputStream(propertiesPath + "\\" + fileName);
			properties.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}