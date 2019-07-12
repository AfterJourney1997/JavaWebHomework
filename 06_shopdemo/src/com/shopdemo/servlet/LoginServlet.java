package com.shopdemo.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopdemo.dao.TemporaryCartDAO;
import com.shopdemo.dao.UserDAO;
import com.shopdemo.entity.CartDO;
import com.shopdemo.entity.UserDO;
import com.shopdemo.util.CookieUtil;
import com.shopdemo.util.DAOFactory;
import com.shopdemo.util.StringEmptyUtil;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private UserDAO userDAO = (UserDAO)DAOFactory.getDAO(DAOFactory.USER_DAO_CLASS_NAME);
	private TemporaryCartDAO temporaryCartDAO = (TemporaryCartDAO) DAOFactory.getDAO(DAOFactory.TEMPORARY_CART_DAO_CLASS_NAME);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String account = null;
		String password = null;
		String rememberUser = null;
		
		// 判断cookie中是否已经保存了用户登录信息，有则将用户信息读出存进session，重定向到首页
		if(CookieUtil.getCookie(request.getCookies(), account) != null) {
			
			try {
				UserDO user = userDAO.getUserByAccount(CookieUtil.getCookie(request.getCookies(), account).getValue());
				request.getSession().setAttribute("user", user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("home");
			return;
		}
		
		account = request.getParameter("account");
		password = request.getParameter("password");
		rememberUser =request.getParameter("remember");
		
		System.out.println("账号：" + account + "\n密码：" + password);
		
		// 判断账号密码是否为空
		if(StringEmptyUtil.stringEmpty(account) || StringEmptyUtil.stringEmpty(password)) {
			System.out.println("账号或密码为空！");
			request.setAttribute("info", "账号或密码不能为空，请重新登录");
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			return;
		}
		
		UserDO user = null;
		try {
			user = userDAO.findUser(account, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 判断账号密码是否正确
		if(user == null) {
			System.out.println("账号或密码错误！");
			request.setAttribute("info", "账号或密码错误，请重新登录");
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			return;
		}
		
		request.getSession().setAttribute("user", user);
		
		if("1".equals(rememberUser)) {
			Cookie accountCookie = new Cookie("account", user.getAccount());
			Cookie loginTimeCookie = new Cookie("loginTime", user.getLoginTime()+"");
			accountCookie.setMaxAge(7 * 24 * 60 * 60);
			loginTimeCookie.setMaxAge(7 * 24 * 60 * 60);
			accountCookie.setPath("/");
			loginTimeCookie.setPath("/");
			response.addCookie(accountCookie);
			response.addCookie(loginTimeCookie);
		}
		
		@SuppressWarnings("unchecked")
		Map<String, CartDO> cartList = (HashMap<String, CartDO>)request.getSession().getAttribute("cartList");
		
		// 判断游客购物车中是否有商品，如有则添加进登录账号的购物车中
		if(cartList != null) {
			for(CartDO cartDO : cartList.values()) {
				temporaryCartDAO.addToCart(user.getAccount(), cartDO);
			}
		}
		
		response.sendRedirect("home");
		
	}

}
