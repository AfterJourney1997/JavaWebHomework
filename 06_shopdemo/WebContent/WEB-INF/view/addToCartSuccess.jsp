<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>shopdemo - 添加到购物车成功</title>
</head>
<body>
	<h2>添加到购物车成功！</h2>
	
	<%String ref = request.getHeader("REFERER"); %>
    <input type="button" id="backBtn" name="button" class="button_return" value="继续购物" 
		onclick="javascript:window.location='<%=ref %>'">

</body>
</html>