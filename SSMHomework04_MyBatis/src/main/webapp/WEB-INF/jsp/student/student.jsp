<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/reset.css">
    <title>省级初中信息技术结业在线考试系统 - 学生</title>
</head>
<style  type="text/css">
    body {
        padding-top: 50px;
    }
    .main {
        padding: 20px;
    }
    @media (min-width: 768px) {
        .main {
            padding-right: 40px;
            padding-left: 40px;
        }
    }
    .main {
        margin-top: 0;
    }
    .wrap{
        background:#444 url(${pageContext.request.contextPath}/images/home-back.jpg) no-repeat fixed center center;
        background-size: cover;
        overflow: hidden;
        height: 850px;
    }
</style>
<body>
<div>
    <%@include file="../head.jsp"%>
    <%@include file="../leaf.jsp"%>
    <div class=" main">
        <div class="wrap"></div>
    </div>
</div>
</body>
</html>
