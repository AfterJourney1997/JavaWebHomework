
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>shopdemo - 完善个人信息1</title>
</head>
<body>
    <form action="preference1" method="POST">
        学校名称：<input type="text" name="schoolName"><br><br>
        专业方向：<select name="profession">
        <option value="软件工程金融信息化方向">软件工程金融信息化方向</option>
        <option value="软件工程互联网方向">软件工程互联网方向</option>
        <option value="软件工程大数据方向">软件工程大数据方向</option>
        <option value="软件工程移动方向">软件工程移动方向</option>
        <option value="软件工程卓越工程师方向">软件工程卓越工程师方向</option>
    </select><br><br>
        <input type="submit" value="下一步">
    </form>
</body>
</html>
