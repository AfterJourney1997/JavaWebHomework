<%@ page import="com.shopdemo.entity.User" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <% User user = (User) session.getAttribute("user"); %>
    <title>shopdemo - 个人中心</title>
</head>
<body>
    <p>首页 --> 个人中心</p><br>
    账号：<%=user.getAccount()%>
    <a href="preference1.jsp"><button>完善个人信息</button></a>
</body>
</html>
