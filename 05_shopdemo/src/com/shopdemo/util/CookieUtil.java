package com.shopdemo.util;

import javax.servlet.http.Cookie;

public class CookieUtil {

	public static Cookie getCookie(Cookie[] cookies, String key) {
		
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(key!=null && key.equals(cookie.getName())) {
					return cookie;
				}
			}
		}
		return null;
	}
	
}
