package com.shopdemo.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopdemo.dao.GoodsDAO;
import com.shopdemo.entity.GoodsDO;
import com.shopdemo.util.DAOFactory;
import com.shopdemo.util.StringEmptyUtil;

@WebServlet("/searchGoods")
public class SearchGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	GoodsDAO goodsDAO = (GoodsDAO)DAOFactory.getDAO(DAOFactory.GOODS_DAO_CLASS_NAME);
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String goodsName = request.getParameter("search");
		GoodsDO goods = null;
		
		if(!StringEmptyUtil.stringEmpty(goodsName)) {
			goodsName = goodsName.trim();
		}
		
		try {
			goods = goodsDAO.getGoodsByName(goodsName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<GoodsDO> goodsList = new ArrayList<>();
		
		if(goods != null) {
			goodsList.add(goods);
		}
		
		request.setAttribute("goodsList", goodsList);
		
		request.getRequestDispatcher("/WEB-INF/view/searchGoods.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
