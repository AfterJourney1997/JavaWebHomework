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
    .sidebar {
        display: none;
    }
    @media (min-width: 768px) {
        .sidebar {
            position: fixed;
            top: 50px;
            bottom: 0;
            left: 0;
            z-index: 1000;
            display: block;
            padding: 20px;
            overflow-x: hidden;
            overflow-y: auto; /* Scrollable contents if viewport is shorter than content. */
            background-color: #f5f5f5;
            border-right: 1px solid #eee;
        }
    }
    .nav-sidebar {
        margin-right: -21px; /* 20px padding + 1px border */
        margin-bottom: 20px;
        margin-left: -20px;
    }
    .nav-sidebar > li > a {
        padding-right: 20px;
        padding-left: 20px;
    }
    .nav-sidebar > .active > a,
    .nav-sidebar > .active > a:hover,
    .nav-sidebar > .active > a:focus {
        color: #fff;
        background-color: #428bca;
    }
</style>

<body>
    <!-- 加一个判断条件 -->
    <c:if test="${sessionScope.identity == 1}">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="${pageContext.request.contextPath}/student">学生<span class="sr-only">(current)</span></a></li>
                <li><a href="${pageContext.request.contextPath}/student/examInfo"> 查看考试</a></li>
                <li><a href="${pageContext.request.contextPath}/student/result"> 查看成绩</a></li>
            </ul>
        </div>
    </c:if>

    <c:if test="${sessionScope.identity == 2}">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">学生管理<span class="sr-only">(current)</span></a></li>
                <li><a href="${pageContext.request.contextPath}/studentadd"> 添加学生</a></li>
                <li><a href="${pageContext.request.contextPath}/studentdel?scid=${sessionScope.school.getScId()}"> 删除学生</a></li>
                <li><a href="${pageContext.request.contextPath}/studentsel"> 查询学生</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">试卷管理<span class="sr-only">(current)</span></a></li>
                <li><a href="${pageContext.request.contextPath}/testadd"> 添加试卷</a></li>
                <li><a href="${pageContext.request.contextPath}/testdel"> 删除试卷</a></li>
                <li><a href="${pageContext.request.contextPath}/testcor"> 批改试卷</a></li>
            </ul>
        </div>
    </c:if>

    <c:if test="${sessionScope.identity == 3}">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">考试管理<span class="sr-only">
                    (current)</span></a></li>
                <li><a href="${pageContext.request.contextPath}/arrangeadd">添加考试</a></li>
                <li><a href="#">删除考试</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">教师管理<span class="sr-only">
                    (current)</span></a></li>
                <li><a href="#">添加教师</a></li>
                <li><a href="#">删除教师</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">学校管理<span class="sr-only">
                    (current)</span></a></li>
                <li><a href="#">添加学校</a></li>
                <li><a href="#">删除学校</a></li>
            </ul>
        </div>
    </c:if>

</html>
