package com.webServerBySocketForDifferentPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.webServerBySocketForDifferentPath.util.GetResquestPathUtil;
import com.webServerBySocketForDifferentPath.util.PropertiesUtil;

public class Main {

	public static void main(String[] args) {
		
		try {
			ServerSocket serverSocket = new ServerSocket(8888);
			ThreadForWebServer threadForWebServer = new ThreadForWebServer(serverSocket);
			Thread thread = new Thread(threadForWebServer);
			thread.start();
			
		}catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
}

class ThreadForWebServer implements Runnable{
	
	// 访问次数
	int visitNum = 0;
	ServerSocket serverSocket;
	
	public ThreadForWebServer(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}
	
	@Override
	public void run() {
		try {
			// 死循环保证可以一直响应
			while(true) {
				Socket socket = serverSocket.accept();
				OutputStream outputStream = socket.getOutputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				// 读取请求头
				String line = br.readLine();
				// 读取请求头中的访问路径，并去掉/，将首字母转为大写
				String resquestPath = GetResquestPathUtil.getResquestPathWithoutFirstChar(line);
				System.out.println("访问路径是：" + resquestPath);
				
				try {
					// 读取配置文件中的响应类的响应方法名称
					String create = PropertiesUtil.getPropertiesByKey("responseClass.properties", "create");
					
					// 根据访问路径通过反射读取到对应的响应类
					Class<?> clazz = Class.forName("com.webServerBySocketForDifferentPath.response.ResponseFor" + resquestPath);
					// 调用响应类对应的响应方法来读取对应的html，拼接响应体，返回字符串
					String responseMessage = (String) clazz.getMethod(create).invoke(clazz.newInstance());

					// 如果没有对应的html页面或访问路径没有对应的响应类，则返回403页面
					if(responseMessage.isEmpty() || responseMessage == null) {
						clazz = Class.forName("com.webServerBySocketForDifferentPath.response.ResponseForNotFound");
						responseMessage = (String) clazz.getMethod(create).invoke(clazz.newInstance());
					}
					
					outputStream.write(responseMessage.getBytes());
				} catch (ClassNotFoundException e) {
					
					System.err.println("未找到路径为" + resquestPath + "对应的响应类");
					e.printStackTrace();
					
					String create = PropertiesUtil.getPropertiesByKey("responseClass.properties", "create");
					
					try {
						Class<?> clazz = Class.forName("com.webServerBySocketForDifferentPath.response.ResponseForNotFound");
						String responseMessage = (String) clazz.getMethod(create).invoke(clazz.newInstance());
						
						outputStream.write(responseMessage.getBytes());
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} finally {
						outputStream.flush();
						outputStream.close();
						
					}
					
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				System.out.println("第" + (++visitNum) + "次访问。");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
