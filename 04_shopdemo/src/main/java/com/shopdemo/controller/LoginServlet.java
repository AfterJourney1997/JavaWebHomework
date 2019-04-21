package com.shopdemo.controller;

import com.shopdemo.config.info.LoginErrorEnum;
import com.shopdemo.entity.User;
import com.shopdemo.entity.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="Login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    // 判断账号和密码是否为空，为空返回错误信息，否则返回null
    private String checkLogin(User user){

        String errorInfo = null;

        if (user.getAccount() == null || "".equals(user.getAccount().trim())
                || user.getPassword() == null || "".equals(user.getPassword().trim())){
            errorInfo = LoginErrorEnum.ACCOUNT_OR_PASSWORD_EMPTY.getInfo();
        }
        return errorInfo;

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String account = request.getParameter("account");
        String password = request.getParameter("password");
        System.out.println("登录账号：" + account + "，密码：" + password);

        User user = new User(account, password, new UserInfo());
        String errorInfo = checkLogin(user);
        String targetPath = "homePageView";

        if(errorInfo == null){
            // 登录成功，对登录信息进行保存
            request.getSession().setAttribute("user", user);
        }else {
            // 登录失败，返回登录页面，并将错误信息返回
            targetPath = "loginPageView";
            System.out.println("登录失败：" + errorInfo);
            request.setAttribute("errorInfo", errorInfo);
        }

        request.getRequestDispatcher(targetPath).forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
