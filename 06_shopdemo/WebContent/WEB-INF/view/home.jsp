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

<title>shopdemo - 首页</title>
</head>
<body>

	<c:set var="account1" value="请登录" scope="request" />
	<%
		String account = "请登录";
		Cookie accountCookie = CookieUtil.getCookie(request.getCookies(), "account");
	
		if(accountCookie != null){
			account = accountCookie.getValue();
		}
	
		if(session.getAttribute("user") != null){
			UserDO user = (UserDO)session.getAttribute("user");
			account = user.getAccount();
		}
	%>
	
	<%@include file="header.jsp"%>
	

	<h2>欢迎你！${requestScope.account } ${requestScope.account1 }</h2>
	

	
	<button onclick="location.href='<%=request.getContextPath() %>/cart'">购物车</button>
	<br>
	
	<%
		if("游客".equals(account)){
	%>
	<button>注册</button>
	<button onclick="location.href='<%=request.getContextPath() %>/loginView'">登录</button>
	<%
		}else{
	%>
	<button onclick="location.href='<%=request.getContextPath() %>/logOut'">注销</button>
	<%
		}
	%>
	<button onclick="location.href='<%=request.getContextPath() %>/cart'">购物车</button>
	<br>
	
	<h2>欢迎你！${requestScope.account } ${requestScope.account1 }</h2>

	<form action="<%=request.getContextPath() %>/searchGoods" method="get">
		<div class="form-group container-fluid">
			<div class="row">
				<div class="col-md-5 col-md-offset-3">
					<input class="form-control" type="text" name="search" placeholder="输入你想要搜索的宝贝">
				</div>
				<div class="col-md-1">
					<input class="btn btn-default" type="submit" value="搜索🔍">
				</div>
			</div>
		</div>
	</form>
	
	<br><br><br>
	
	<%
		GoodsDAO goodsDAO = (GoodsDAO)DAOFactory.getDAO(DAOFactory.GOODS_DAO_CLASS_NAME);
		ArrayList<GoodsDO> goodsList = (ArrayList<GoodsDO>)goodsDAO.getAll();
	%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
	<table class="table table-striped table-hover">
		<tr>
			<th>#</th>
			<th>商品编号</th>
			<th>商品名称</th>
			<th>商品价格</th>
			<th>商品描述</th>
			<th>操作</th>
		</tr>
		<%
			for(int i = 0; i<goodsList.size(); i++){
		%>
		<tr>
			<td><%=i+1 %></td>
			<td><%=goodsList.get(i).getId() %></td>
			<td><%=goodsList.get(i).getName() %></td>
			<td><%=goodsList.get(i).getPrice() %></td>
			<td><%=goodsList.get(i).getDescription() %></td>
			<td>
				<form action="<%=request.getContextPath() %>/addGoodsToCart?goodsId=<%=goodsList.get(i).getId() %>" method="post">
					<input class="btn btn-default btn-sm" type="submit" value="加入购物车🛒">
				</form>
			</td>
		</tr>
		<%
			}
		%>
	</table>
			</div>
		</div>
	</div>
</body>
</html>