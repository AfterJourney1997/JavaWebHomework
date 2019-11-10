<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <title></title>
</head>
<style type="text/css">
    .navbar-fixed-top {
        border: 0;
    }
</style>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">省级初中信息技术结业在线考试系统</a>
        </div>
            <p class="navbar-text navbar-right">
                <c:if test="${sessionScope.identity == 1}">
                    欢迎你，${sessionScope.user.getSName()}同学 &nbsp;&nbsp;
                </c:if>
                <c:if test="${sessionScope.identity == 2}">
                    欢迎你，${sessionScope.user.getTName()}老师 &nbsp;&nbsp;
                </c:if>
                <c:if test="${sessionScope.identity == 3}">
                    欢迎你，管理员 &nbsp;&nbsp;
                </c:if>
                <a href="${pageContext.request.contextPath}/exit" class="navbar-link">退出</a>
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </p>

    </div>
</nav>
</body>
</html>
