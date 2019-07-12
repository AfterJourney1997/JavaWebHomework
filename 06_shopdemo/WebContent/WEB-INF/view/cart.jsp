<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.shopdemo.dao.*" %>
<%@ page import="com.shopdemo.util.*" %>
<%@ page import="com.shopdemo.entity.UserDO" %>
<%@ page import="com.shopdemo.entity.CartDO" %>
<%@ page import="com.shopdemo.entity.GoodsDO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>shopdemo - 购物车</title>
</head>
<body>
	<%
		UserDO user = (UserDO) session.getAttribute("user");
		String account = null;
		ArrayList<CartDO> cartList = null;
		
		if(user == null){
			
			Map<String, CartDO> cartMap = (HashMap<String, CartDO>) session.getAttribute("cartList");
			cartList = new ArrayList<CartDO>(cartMap.values());
			
		}else{
			
			account = user.getAccount();
			TemporaryCartDAO temporaryCartDAO = (TemporaryCartDAO) DAOFactory.getDAO(DAOFactory.TEMPORARY_CART_DAO_CLASS_NAME);
			cartList = (ArrayList<CartDO>)temporaryCartDAO.getAllFromCart(account);
			
		}
	%>
	<h2>购物车</h2>
	
	<table border="1">
		<tr>
			<th>商品编号</th>
			<th>商品名称</th>
			<th>商品单价</th>
			<th>商品数量</th>
			<th>总价</th>
		</tr>
		<%
			for(int i = 0; i<cartList.size(); i++){
		%>
		<tr>
			<td><%=cartList.get(i).getGoodsDO().getId() %></td>
			<td><%=cartList.get(i).getGoodsDO().getName() %></td>
			<td><%=cartList.get(i).getGoodsDO().getPrice() %></td>
			<td><%=cartList.get(i).getNumber() %></td>
			<td><%=cartList.get(i).getTotlePrice() %></td>
		</tr>
		<%
			}
		%>
	</table>
	
</body>
</html>