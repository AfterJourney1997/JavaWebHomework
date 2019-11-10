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
    <h3>试卷编号：${test.testId}</h3>
    <a href="${pageContext.request.contextPath}/testdel">
        <button type="button" class="btn btn-default">取消删除</button>
    </a>

    <table class="table table-hover table-striped">
        <tr>
            <th>选择题编号</th>
            <th>问题</th>
            <th>选项一</th>
            <th>选项二</th>
            <th>选项三</th>
            <th>选项四</th>
            <th>答案</th>
        </tr>
        <c:forEach var="choice" items="${listChoice}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${choice.cqContent}</td>
                <td>${choice.cqA}</td>
                <td>${choice.cqB}</td>
                <td>${choice.cqC}</td>
                <td>${choice.cqD}</td>
                <td>${choice.cqCorrect}</td>
            </tr>
        </c:forEach>
    </table>

    <table class="table table-hover table-striped">
        <tr>
            <th>判断题编号</th>
            <th>问题</th>
            <th>答案</th>
        </tr>
        <c:forEach var="trueFalse" items="${listTrueFalse}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${trueFalse.tfqContent}</td>
                <td>${trueFalse.tfqCorrect}</td>
            </tr>
        </c:forEach>
    </table>

    <table class="table table-hover table-striped">
        <tr>
            <th>简答题编号</th><th>问题</th><th>答案</th>
        </tr>
        <c:forEach var="shortanswer" items="${listShort}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${shortanswer.saqContent}</td>
                <td>${shortanswer.saqCorrect}</td>
            </tr>
        </c:forEach>
    </table>

    <div style="vertical-align:middle;text-align:center;">
        <form class="form-inline" action="${pageContext.request.contextPath}/deltest">
            <div class="form-group">
                <label>删除试卷编号</label>
                <input type="text" class="form-control" name="testId" value="${test.testId}" readonly>
            </div>
            <button type="submit" class="btn btn-primary">删除</button>
        </form>
    </div>


</div>
</body>
</html>
