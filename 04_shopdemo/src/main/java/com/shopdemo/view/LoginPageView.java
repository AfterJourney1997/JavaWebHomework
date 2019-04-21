package com.shopdemo.view;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginPageView", urlPatterns = "/loginPageView")
public class LoginPageView extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML>");
        out.println("<html>");
        out.println("<head><title>shopdemo - 登录页面</title></head>");
        out.println("<body>");
        String errorInfo = (String) request.getAttribute("errorInfo");
        if(errorInfo != null){
            out.println("请重新登录：<font color='red'>" + errorInfo + "</font><br>");
        }
        String body = "<form action='login' method='POST'>" +
                "账号：<input type='text' name='account'/><br>" +
                "密码：<input type='password' name='password'/><br>" +
                "<input type='submit' value='登录'/></form>";
        out.println(body);
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }
}
