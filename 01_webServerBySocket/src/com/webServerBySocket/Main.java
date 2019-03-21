package com.webServerBySocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.webServerBySocket.response.WebServer;

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
	
	int visitNum = 0;
	ServerSocket serverSocket;
	
	public ThreadForWebServer(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				Socket socket = serverSocket.accept();
				new WebServer(socket).returnHtml();
				System.out.println("第" + (++visitNum) + "次访问。");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
