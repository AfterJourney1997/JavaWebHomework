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
    <title>省级初中信息技术结业在线考试系统 - 删除试卷</title>
</head>
<body>
<%@include file="head.jsp"%>
<%@include file="leaf.jsp"%>

<div class="main">
    ${mg}
    <table class="table table-hover table-striped">
        <tr>
            <th>试卷编号</th>
            <th>试卷名称</th>
            <th>详情</th>
            <th>操作</th>
        </tr>
        <c:forEach var="alltest" items="${listAllTest}">
            <tr>
                <td>${alltest.testId}</td>
                <td>${alltest.testName}</td>
                <td><a href="${pageContext.request.contextPath}/looktest?testId=${alltest.testId}">点击查看试卷</a></td>
                <td><a href="${pageContext.request.contextPath}/deltest?testId=${alltest.testId}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
