package com.webServerBySocket.test;

import java.io.File;

public class Test {

	public static void main(String[] args) {
		File file = new File(System.getProperty("user.dir") + "\\webRoot\\index.html");
		System.out.println(file.exists());
	}
	
}
