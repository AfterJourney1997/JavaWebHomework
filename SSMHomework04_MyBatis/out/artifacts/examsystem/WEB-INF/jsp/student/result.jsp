<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/body.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
    <link href="${pageContext.request.contextPath}/css/reset.css">

    <title>省级初中信息技术结业在线考试系统 - 学生考试信息</title>
</head>
<body>
<%@include file="../head.jsp"%>
<%@include file="../leaf.jsp"%>
<div class=" main">

    <div>
        <table class="table table-striped table-hover">
            <tr>
                <th>#</th>
                <th>考试</th>
                <th>考生账号</th>
                <th>考生姓名</th>
                <th>成绩</th>
            </tr>
            <c:forEach var="item" items="${requestScope.result}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${item.arrName}</td>
                    <td>${sessionScope.user.getSAccount()}</td>
                    <td>${sessionScope.user.getSName()}</td>
                    <td>${item.fraction}</td>

                </tr>
            </c:forEach>
        </table>
    </div>

</div>
</body>
</html>
