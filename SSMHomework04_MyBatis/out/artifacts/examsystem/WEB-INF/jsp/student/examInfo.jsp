<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link href="${pageContext.request.contextPath}/css/body.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
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
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
                <c:forEach var="item" items="${requestScope.exam}" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${item.arrName}</td>
                        <td>${item.arrStart}</td>
                        <td>${item.arrStop}</td>
                        <td>
                            <c:if test="${item.arrStatus == -1}">
                                <span class="label label-primary">已结束</span>
                            </c:if>
                            <c:if test="${item.arrStatus == 0}">
                                <span class="label label-info">未开始</span>
                            </c:if>
                            <c:if test="${item.arrStatus == 1}">
                                <span class="label label-warning">进行中</span>
                            </c:if>
                            <c:if test="${item.arrStatus == 2}">
                                <span class="label label-success">已完成</span>
                            </c:if>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${item.arrStatus == 1}">
                                    <a href="${pageContext.request.contextPath}/student/exam?arrId=${item.arrId}&testId=${item.testId}">
                                        <button type="button" class="btn btn-primary">开始考试</button>
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <button type="button" class="btn btn-primary" disabled="disabled">开始考试</button>
                                </c:otherwise>
                            </c:choose>

                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>

    </div>
</body>
</html>
