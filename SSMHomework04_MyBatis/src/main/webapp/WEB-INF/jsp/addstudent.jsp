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
    <title>省级初中信息技术结业在线考试系统 - 添加学生</title>
</head>

<body>
<%@include file="head.jsp"%>
<%@include file="leaf.jsp"%>

<div class="main">
    <c:if test="${!empty model}">
        <div style="text-align: center;">${model}</div>
    </c:if>
    <form class="form-horizontal" action="${pageContext.request.contextPath}/addstudent" method="post">
        <div class="form-group">
            <label class="col-sm-2 control-label">学生学号</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" name="sAccount" placeholder="学生学号">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">学生姓名</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" name="sName" placeholder="学生姓名">
            </div>
        </div>
        <input type="hidden" class="form-control" name="scId" value="${sessionScope.school.getScId()}">

        <button style="margin: 0 auto" type="submit" class="btn btn-default">添加</button>

    </form>
</div>

</body>
</html>