<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.shopdemo.entity.UserDO" %>
<%@ page import="com.shopdemo.entity.GoodsDO" %>
<%@ page import="com.shopdemo.dao.*" %>
<%@ page import="com.shopdemo.util.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>shopdemo - 首页</title>
</head>
<body>
	<%
		String account = "游客";
		Cookie accountCookie = CookieUtil.getCookie(request.getCookies(), "account");
	
		if(accountCookie != null){
			account = accountCookie.getValue();
		}
	
		if(session.getAttribute("user") != null){
			UserDO user = (UserDO)session.getAttribute("user");
			account = user.getAccount();
		}
	%>

	<h2>欢迎你！<%=account %></h2>
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
	<br>
	<h2>商品列表</h2>

	<form action="<%=request.getContextPath() %>/searchGoods" method="get">
		<input type="text" name="search"><br>
		<input type="submit" value="搜索">
	</form>
	
	<%
		GoodsDAO goodsDAO = (GoodsDAO)DAOFactory.getDAO(DAOFactory.GOODS_DAO_CLASS_NAME);
		ArrayList<GoodsDO> goodsList = (ArrayList<GoodsDO>)goodsDAO.getAll();
	%>
	
	<table border="1">
		<tr>
			<th>商品编号</th>
			<th>商品名称</th>
			<th>商品价格</th>
			<th>商品描述</th>
		</tr>
		<%
			for(int i = 0; i<goodsList.size(); i++){
		%>
		<tr>
			<td><%=goodsList.get(i).getId() %></td>
			<td><%=goodsList.get(i).getName() %></td>
			<td><%=goodsList.get(i).getPrice() %></td>
			<td><%=goodsList.get(i).getDescription() %></td>
			<td>
				<form action="<%=request.getContextPath() %>">
					
				</form>
			</td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>