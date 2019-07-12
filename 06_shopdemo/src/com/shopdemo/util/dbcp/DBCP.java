package com.shopdemo.util.dbcp;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class DBCP {

	// 定义一个连接池对象
	private static DataSource dataSource;
	
	static{
        try {
            Properties properties = new Properties();
            InputStream resourceAsStream = DBCP.class.getClassLoader().getResourceAsStream("config/dbcp.properties");
            properties.load(resourceAsStream);
            //得到一个连接池对象
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
        	e.printStackTrace();
            throw new ExceptionInInitializerError("初始化连接错误，请检查配置文件！");
        }
    }
	
    // 从池中获取一个连接
    public static Connection getConnection() throws SQLException{
        return dataSource.getConnection();
    }
    
    // 获取dataSource
    public static DataSource getDataSource() {
		return dataSource;
	}
    
    public static void closeAll(ResultSet rs,Statement stmt,Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        if(conn!=null){
            try {
                conn.close();//关闭
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
