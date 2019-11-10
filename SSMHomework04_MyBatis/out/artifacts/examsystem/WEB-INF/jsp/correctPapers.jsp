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
    学生：${answer.SName}&emsp;&emsp;学号：${answer.SAccount}

    <table class="table table-striped table-hover">
        <tr>
            <th>序号</th>
            <th>选择题</th>
            <th>选项A</th>
            <th>选项B</th>
            <th>选项C</th>
            <th>选项D</th>
            <th>答案</th>
            <th>学生选项</th>
            <th>得分</th>
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
                <td>${choiceArray[status.index]}</td>
                <td>${gradeArarry[status.index]}</td>
            </tr>
        </c:forEach>
    </table>

    <table class="table table-striped table-hover">
        <tr>
            <th>判断题编号</th>
            <th>问题</th>
            <th>答案</th>
            <th>学生选项</th>
            <th>得分</th>
        </tr>
        <c:forEach var="trueFalse" items="${listTrueFalse}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${trueFalse.tfqContent}</td>
                <td>${trueFalse.tfqCorrect}</td>
                <td>${truefalseArray[status.index]}</td>
                <td>${gradeArarry[status.index + 15]}</td>
            </tr>
        </c:forEach>
    </table>

    <table class="table table-striped table-hover">
        <tr>
            <th>简答题编号</th>
            <th>问题</th>
            <th>参考答案</th>
            <th>学生答案</th>
            <th>批阅</th>
        </tr>
        <form action="${pageContext.request.contextPath}/addgrade">
            <c:forEach var="shortanswer" items="${listShort}" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${shortanswer.saqContent}</td>
                    <td>${shortanswer.saqCorrect}</td>
                    <td>${shortAnswerArray[status.index]}</td>
                    <td>
                        <div class="form-group">
                            <select name="grade${status.count}" class="form-control">
                                <option value ="0">C-</option>
                                <option value ="4">C</option>
                                <option value="8">B-</option>
                                <option value="12">B</option>
                                <option value="16">A-</option>
                                <option value="20">A</option>
                            </select>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            <input type="hidden" name="ansId" value="${answer.answerId}"/>
            <tr>
                <td></td><td></td>
                <td>
                    <button style="width: 100%" type="submit" class="btn btn-default">提交</button>
                </td>
                <td></td><td></td>

            </tr>
        </form>

    </table>
</div>
</body>
</html>
