package com.shopdemo.util;

public class StringEmptyUtil {

	public static boolean stringEmpty(String str) {
		
		if(str == null || "".equals(str)) {
			return true;
		}
		
		return false;
		
	}
	
}
