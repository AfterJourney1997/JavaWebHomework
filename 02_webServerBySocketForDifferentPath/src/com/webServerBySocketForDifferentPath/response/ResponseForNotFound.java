package com.webServerBySocketForDifferentPath.response;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.webServerBySocketForDifferentPath.util.PropertiesUtil;

// 403页面
public class ResponseForNotFound {
	
	public String create() {
		
		File file = new File(PropertiesUtil.getHtmlPathByProperties("htmlPath.properties", "notFound"));
		
		if(file.exists()) {
			
			try {
				
				BufferedReader br = new BufferedReader(new FileReader(file));
				StringBuffer sb = new StringBuffer();
				StringBuffer result = new StringBuffer();
				String temp = null;
				
				// 循环读取html文件内容
				while((temp = br.readLine()) != null) {
					sb.append(temp).append("\r\n");
				}
				br.close();
				
				result.append("HTTP/1.1 200 ok \r\n");
				result.append("Content-Language:zh-CN \r\n");
				// charset=UTF-8 解决中文乱码问题
				result.append("Content-Type:text/html;charset=UTF-8 \r\n");
				result.append("Content-Length:" + file.length() + "\r\n");
				result.append("\r\n" + sb.toString());
				
				return result.toString();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return null;
		
	}
	
}
