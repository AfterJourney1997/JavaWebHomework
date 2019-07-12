<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>shopdemo - 登录</title>
</head>
<body>
	<%
		if(request.getAttribute("info") != null){	
	%>
	<p style="color:red"><%=request.getAttribute("info") %></p>
	<%
		}
	%>
	<form action="<%=request.getContextPath() %>/login" method="post">
		账号：<input type="text" name="account"><br>
		密码：<input type="password" name="password"><br>
		<input type="submit" value="登录"> 
		<input type="radio" name="remember" value="1">7天内自动登录
	</form>
</body>
</html>