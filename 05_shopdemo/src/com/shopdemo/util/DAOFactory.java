package com.shopdemo.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.shopdemo.dao.BaseDAO;

public class DAOFactory {
	
    public static String GOODS_DAO_CLASS_NAME;
    public static String PERSONAL_DAO_CLASS_NAME;
    public static String USER_DAO_CLASS_NAME;
    public static String TEMPORARY_CART_DAO_CLASS_NAME;
	
    public DAOFactory() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    static {
    	/*
    	 * getResourceAsStream有以下几种： 
    	 * 1. Class.getResourceAsStream(String path) ： path 不以’/'开头时默认是从此类所在的包下取资源，以’/'开头则是从
    	 * ClassPath根下获取。其只是通过path构造一个绝对路径，最终还是由ClassLoader获取资源。
    	 * 2. Class.getClassLoader.getResourceAsStream(String path) ：默认则是从ClassPath根下获取，path不能以’/'开头，最终是由ClassLoader获取资源。
    	 * 3. ServletContext. getResourceAsStream(String path)：默认从WebAPP根目录下取资源，Tomcat下path是否以’/'开头无所谓
    	 */
    	InputStream in = DAOFactory.class.getResourceAsStream("/config/className.properties");
    	Properties pr = new Properties();
    	try {
			pr.load(in);
			GOODS_DAO_CLASS_NAME = pr.getProperty("GOODS_DAO_CLASS_NAME");
			PERSONAL_DAO_CLASS_NAME = pr.getProperty("PERSONAL_DAO_CLASS_NAME");
			USER_DAO_CLASS_NAME =  pr.getProperty("USER_DAO_CLASS_NAME");
			TEMPORARY_CART_DAO_CLASS_NAME =  pr.getProperty("TEMPORARY_CART_DAO_CLASS_NAME");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static BaseDAO getDAO(String className){
    	
        if(!StringEmptyUtil.stringEmpty(className)){
        	
            try {
            	Class<? extends BaseDAO> clazz = (Class<? extends BaseDAO>)Class.forName(className);
                return clazz.getConstructor().newInstance();
                
            } catch (Exception e) {
            	
                e.printStackTrace();
            }
        }
        
        return null;
    }
}
