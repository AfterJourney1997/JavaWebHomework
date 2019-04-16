package com.shopdemo.controller;

import com.shopdemo.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Preference1", urlPatterns = "/preference1")
public class Preference1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        User user = (User)request.getSession().getAttribute("user");
        String schoolName = request.getParameter("schoolName");
        String profession = request.getParameter("profession");
        System.out.println(schoolName + " " + profession);

        user.getUserInfo().setSchoolName(schoolName);
        user.getUserInfo().setProfession(profession);
        System.out.println(user);
        request.getSession().setAttribute("user", user);

        String targetPath = "preference2PageView";
        request.getRequestDispatcher(targetPath).forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
