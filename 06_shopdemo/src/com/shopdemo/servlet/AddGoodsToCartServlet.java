package com.shopdemo.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopdemo.dao.GoodsDAO;
import com.shopdemo.dao.TemporaryCartDAO;
import com.shopdemo.entity.CartDO;
import com.shopdemo.entity.UserDO;
import com.shopdemo.util.DAOFactory;

@WebServlet("/addGoodsToCart")
public class AddGoodsToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	TemporaryCartDAO temporaryCartDAO = (TemporaryCartDAO) DAOFactory.getDAO(DAOFactory.TEMPORARY_CART_DAO_CLASS_NAME);
    GoodsDAO goodsDAO = (GoodsDAO) DAOFactory.getDAO(DAOFactory.GOODS_DAO_CLASS_NAME);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String goodsId = request.getParameter("goodsId");
		CartDO cart = null;
		
		// 根据商品id获取商品，并将其封装进CartDO中
		try {
			cart = new CartDO(goodsDAO.getGoodsById(goodsId), 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(request.getSession().getAttribute("user") != null) {
			
			UserDO user = (UserDO) request.getSession().getAttribute("user");
			temporaryCartDAO.addToCart(user.getAccount(), cart);
			
		}else {
			
			@SuppressWarnings("unchecked")
			Map<String, CartDO> cartList = (HashMap<String, CartDO>)request.getSession().getAttribute("cartList");
			
			// 如果session中没有cartList则new一个
			if(cartList == null) {
				cartList = new HashMap<>();
			}
			
			// 如果cartList中没有要添加的商品则直接添加一个进去
			if(!cartList.containsKey(goodsId)) {
				cartList.put(goodsId, cart);
				
			}else {
				CartDO cartDO = cartList.get(goodsId);
				cartDO.setNumber(cartDO.getNumber() + cart.getNumber());
				cartDO.setTotlePrice(cartDO.getTotlePrice() + cart.getTotlePrice());
				cartList.put(goodsId, cartDO);
			}
			
			request.getSession().setAttribute("cartList", cartList);
			
/*			String visitId = (String) request.getSession().getAttribute("visitId");
			
			// 如果该游客没有其id，则使用uuid给他初始化一个
			if(StringEmptyUtil.stringEmpty(visitId)) {
				visitId = UUID.randomUUID().toString();
				request.getSession().setAttribute("visitId", visitId);
			}
			
			temporaryCartDAO.addToCart(visitId, cart);*/
			
			
		}
		request.getRequestDispatcher("/WEB-INF/view/addToCartSuccess.jsp").forward(request, response);
		
	}

}
