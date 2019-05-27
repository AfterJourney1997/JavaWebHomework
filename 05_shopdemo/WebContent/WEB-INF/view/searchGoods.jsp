<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.shopdemo.entity.GoodsDO" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>shopdemo - 搜索商品</title>
</head>
<body>

	<%
		@SuppressWarnings("unchecked")
		ArrayList<GoodsDO> goodsList = (ArrayList<GoodsDO>)request.getAttribute("goodsList");
	%>

	<h2>搜索商品</h2>
	
	<%
		if(goodsList.size() == 0){
	%>
	<p>很抱歉，暂无此商品。</p>
	<%
		}else{
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
		</tr>
		<%
			}
		}
		%>
	</table>
	
</body>
</html>