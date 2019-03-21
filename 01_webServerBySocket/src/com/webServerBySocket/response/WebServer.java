package com.webServerBySocket.response;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class WebServer {

	// html文件地址
	final String htmlUrl = System.getProperty("user.dir") + "\\webRoot\\index.html";
	
	InputStream inputStream;
	OutputStream outputStream;
	
	public WebServer(Socket socket) {
		try {
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void returnHtml() {
		
		File file = new File(htmlUrl);
		
		if(file.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				StringBuffer sb = new StringBuffer();
				StringBuffer result = new StringBuffer();
				String temp = null;
				
				// 循环读取html文件内容
				while((temp = br.readLine()) != null) {
					//System.out.println(temp);
					sb.append(temp).append("\r\n");
				}
				result.append("HTTP/1.1 200 ok \r\n");
				result.append("Content-Language:zh-CN \r\n");
				// charset=UTF-8 解决中文乱码问题
				result.append("Content-Type:text/html;charset=UTF-8 \r\n");
				result.append("Content-Length:" + file.length() + "\r\n");
				result.append("\r\n" + sb.toString());

				outputStream.write(result.toString().getBytes());
				outputStream.flush();
				outputStream.close();
				br.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
}
