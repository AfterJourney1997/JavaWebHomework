package com.shopdemo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logOut")
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		request.getSession().removeAttribute("user");
		
		Cookie accountCookie = new Cookie("account", null);
		Cookie loginTimeCookie = new Cookie("loginTime", null);
		
		accountCookie.setPath("/");
		loginTimeCookie.setPath("/");
		accountCookie.setMaxAge(0);
		loginTimeCookie.setMaxAge(0);
		
		response.addCookie(accountCookie);
		response.addCookie(loginTimeCookie);
		
		response.sendRedirect("home");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
