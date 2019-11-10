<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>省级初中信息技术结业在线考试系统 - 完成考试</title>
</head>
<style>
    /*背景图片*/
    body {
        background-image: url(${pageContext.request.contextPath}/images/congratulations-back.jpg);
        background-repeat: no-repeat;
        background-attachment: fixed;
        background-position: center;
        background-repeat: repeat;
        background-size: cover;
    }
    div {
        position: absolute;
        top: 70%;
        left: 49%;
        margin: -150px 0 0 -200px;
    }
</style>
<body>
    <div>
        <h1>C o n g r a t u l a t i o n s !</h1>
    </div>

    <a style="position: absolute; left: 45%; top: 60%;" href="${pageContext.request.contextPath}/student">
        <button type="button" class="btn btn-default btn-lg">点击返回</button>
    </a>
</body>
</html>
