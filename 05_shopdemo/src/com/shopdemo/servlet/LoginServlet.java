package com.shopdemo.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopdemo.dao.UserDAO;
import com.shopdemo.entity.UserDO;
import com.shopdemo.util.CookieUtil;
import com.shopdemo.util.DAOFactory;
import com.shopdemo.util.StringEmptyUtil;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO = (UserDAO)DAOFactory.getDAO(DAOFactory.USER_DAO_CLASS_NAME);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String account = null;
		String password = null;
		String rememberUser = null;
		
		// 判断cookie中是否已经保存了用户登录信息，有则直接跳转到首页
		if(CookieUtil.getCookie(request.getCookies(), account) != null) {
			response.sendRedirect("home");
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
		
		response.sendRedirect("home");
		
	}

}
