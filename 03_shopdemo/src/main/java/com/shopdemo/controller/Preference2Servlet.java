package com.shopdemo.controller;

import com.shopdemo.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "Preference2Servlet", urlPatterns = "/preference2")
public class Preference2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        User user = (User) request.getSession().getAttribute("user");

        List<String> list = Arrays.asList(request.getParameterValues("technology"));
        user.getUserInfo().setTechnology(list);
        System.out.println(user);

        String targetPath = "homePageView";
        request.getRequestDispatcher(targetPath).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
