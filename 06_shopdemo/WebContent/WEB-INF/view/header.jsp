<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.shopdemo.entity.UserDO" %>
<%@ page import="com.shopdemo.entity.GoodsDO" %>
<%@ page import="com.shopdemo.dao.*" %>
<%@ page import="com.shopdemo.util.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->

<!-- Bootstrap -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
 <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<title>header</title>
</head>
<body>



	<nav class="navbar navbar-default navbar-fixed-top">
		
		<div class="container">
			<p class="navbar-text">
				欢迎你！
				<a href="<%=request.getContextPath() %>/loginView" class="navbar-link">
					${requestScope.account }
				</a>
			</p>
        	<p class="navbar-text navbar-right"><a href="#" class="navbar-link">购物车</a></p>
        	<p class="navbar-text navbar-right"><a href="#" class="navbar-link">我的订单</a></p>
    	</div>
		
		
	</nav>
</body>
</html>