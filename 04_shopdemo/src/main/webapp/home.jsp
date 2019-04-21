<%@ page import="com.shopdemo.entity.User" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <% User user = (User) session.getAttribute("user"); %>
    <title>shopdemo - 首页</title>
</head>
<body>

    <h2>欢迎<%=user.getAccount() %></h2><br>
    <a href="index.jsp">首页</a><br>
    <a href="center">个人中心</a>
</body>
</html>
