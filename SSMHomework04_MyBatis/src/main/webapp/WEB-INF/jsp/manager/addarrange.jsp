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
    <title>省级初中信息技术结业在线考试系统 - 添加考试</title>
</head>
<%@include file="../head.jsp"%>
<%@include file="../leaf.jsp"%>
<body>
<div class="main">
    <c:if test="${!empty requestScope.model}">
        <div style="text-align: center;">${requestScope.model}</div>
    </c:if>
    <form action="${pageContext.request.contextPath}/addarrange" method="post">
        <div class="form-group">
            <label>考试试卷</label>
            <select name="testId" class="form-control">
                <c:forEach var="item" items="${test}">
                    <option value="${item.testId}">${item.testName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label>所属学校</label>
            <select name="scId" class="form-control">
                <c:forEach var="item" items="${requestScope.schools}">
                    <option value="${item.scId}">${item.scName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label>考试名称</label>
            <input type="text" class="form-control" name="arrName" placeholder="考试名称">
        </div>
        <div class="form-group">
            <label>开始时间</label>
            <input type="text" class="form-control" name="arrStart" placeholder="开始时间">
        </div>
        <div class="form-group">
            <label>结束时间</label>
            <input type="text" class="form-control" name="arrStop" placeholder="结束时间">
        </div>

        <input type="hidden" name="arrStatus" value="0"><br>
        <button type="submit" class="btn btn-default">添加</button>
    </form>
</div>
</body>
</html>