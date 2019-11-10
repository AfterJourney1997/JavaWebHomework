<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <link href="${pageContext.request.contextPath}/css/body.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>省级初中信息技术结业在线考试系统 - 查询学生</title>
</head>
<body>
<%@include file="head.jsp"%>
<%@include file="leaf.jsp"%>
<div class="main">

    <form class="form-inline" action="${pageContext.request.contextPath}/selstudent" method="post">
        <div class="form-group">
            <input type="text" class="form-control" name="sid" placeholder="请输入需要查询的学生学号">
        </div>
        <button type="submit" class="btn btn-default">查询</button>
    </form>

    <table class="table table-striped table-hover">
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>成绩</th>
            <th>试卷编号</th>
        </tr>
        <c:forEach var="stums" items="${stums}">
            <tr>
                <td>${stums.SAccount}</td>
                <td>${stums.SName}</td>
                <td>${stums.SResult}</td>
                <td>${stums.testId}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
