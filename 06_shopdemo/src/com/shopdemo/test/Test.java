package com.shopdemo.test;

import java.sql.SQLException;
import java.util.List;

import com.shopdemo.dao.GoodsDAO;
import com.shopdemo.entity.GoodsDO;
import com.shopdemo.util.DAOFactory;

public class Test {
	
	private static GoodsDAO goodsDAO = (GoodsDAO)DAOFactory.getDAO(DAOFactory.GOODS_DAO_CLASS_NAME);
	
	public static void main(String[] args) throws SQLException {
		
		String id = "2c20d9d0-30e6-45cb-83b8-04f1a02e1035";
		
		goodsDAO.getGoodsAndCategory(id);
		
	}
}
