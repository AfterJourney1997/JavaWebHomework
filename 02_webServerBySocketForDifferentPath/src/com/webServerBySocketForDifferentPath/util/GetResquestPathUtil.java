package com.webServerBySocketForDifferentPath.util;

import java.util.Arrays;

// 用于获取请求路径
public class GetResquestPathUtil {

	public static String getResquestPath(String line) {
		
		return Arrays.asList(line.split(" ")).get(1);
		
	}
	
	// 去掉首端的/，并将路径的首字母大写
	public static String getResquestPathWithoutFirstChar(String line) {
		
		System.out.println(line);
		
		String path =  Arrays.asList(line.split(" ")).get(1).substring(1);
		
		if(Character.isLowerCase(path.charAt(0))) {
			return path.substring(0, 1).toUpperCase() + path.substring(1);
		}
		
		return path;
	}
	
}
