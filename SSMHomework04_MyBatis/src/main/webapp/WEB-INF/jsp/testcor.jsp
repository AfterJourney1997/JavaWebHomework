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
    <title>省级初中信息技术结业在线考试系统 - 批改试卷</title>
</head>
<body>
<%@include file="head.jsp"%>
<%@include file="leaf.jsp"%>
<div class="main">
    ${mg}<br>
    ${mes}
    <table class="table table-hover table-striped">
        <tr>
            <th>序号</th>
            <th>考试编号</th>
            <th>试卷编号</th>
            <th>学生学号</th>
            <th>学生姓名</th>
            <th>操作</th>
        </tr>
        <c:forEach var="correctTest" items="${corTest}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${correctTest.arrId}</td>
                <td>${correctTest.testId}</td>
                <td>${correctTest.SAccount}</td>
                <td>${correctTest.SName}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/correctPapers?answerId=${correctTest.answerId}">
                        <button type="button" class="btn btn-default">批改</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
