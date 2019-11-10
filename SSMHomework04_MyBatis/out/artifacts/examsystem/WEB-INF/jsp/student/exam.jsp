<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>省级初中信息技术结业在线考试系统 - 考试</title>
</head>
<style type="text/css">
    .back{
        background:#444 url(${pageContext.request.contextPath}/images/a.jpg) no-repeat fixed center center;
        background-size: cover;
        overflow: hidden;
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
        margin-left: auto;
        margin-right: auto;
        width:900px;
    }
    h4{
        text-align:center;
        font-weight:bold;
    }
</style>
<body>
<div class="back">
    <div class="panel panel-danger main">
        <div class="panel-heading">
            <h4>${sessionScope.examInfo.getArrName()}</h4>
        </div>
        <br><br><br>
        <form id="form" action="${pageContext.request.contextPath}/student/submit" method="POST">

            <div><h3>一、选择题</h3></div>
            <table class="table table-hover table-striped">
                <c:forEach var="item" items="${requestScope.choice}" varStatus="status">
                    <tr>
                        <td colspan="4">${status.index + 1} ${item.cqContent}</td>
                    </tr>
                    <tr>
                        <td><input type="radio" name="cq${status.index + 1}" value="A" checked="checked"/>${item.cqA}</td>
                        <td><input type="radio" name="cq${status.index + 1}" value="B"/>${item.cqB}</td>
                        <td><input type="radio" name="cq${status.index + 1}" value="C"/>${item.cqC}</td>
                        <td><input type="radio" name="cq${status.index + 1}" value="D"/>${item.cqD}</td>
                    </tr>
                </c:forEach>
            </table>

            <div><h3>二、判断题</h3></div>
            <table class="table table-hover table-striped">
                <c:forEach var="item" items="${requestScope.trueFalse}" varStatus="status">
                    <tr>
                        <td colspan="2">${status.index + 1} ${item.tfqContent}</td>
                    </tr>
                    <tr>
                        <td><input type="radio" name="tfq${status.index + 1}" value="T" checked="checked"/>正确</td>
                        <td><input type="radio" name="tfq${status.index + 1}" value="F"/>错误</td>
                    </tr>
                </c:forEach>

            </table>
            <div><h3>三、简答题</h3></div>
            <table class="table table-hover table-striped">
                <c:forEach var="item" items="${requestScope.shortAnswer}" varStatus="status">
                    <tr>
                        <td colspan="2">${status.index + 1} ${item.saqContent}</td>
                    </tr>
                    <tr>
                        <td colspan="2"><textarea class="form-control" rows="3" name="saq${status.index + 1}"></textarea></td>
                    </tr>
                </c:forEach>
            </table>

            <input class="btn btn-success" id="submit" type="button" value="交卷" name="submit">
        </form>
    </div>
</div>

<script>

    $(function () {
        $('#submit').click(function () {
            var d = {};
            var t = $('form').serializeArray();
            $.each(t, function () {
                d[this.name] = this.value;
            });
            console.log(JSON.stringify(d));

            var form = $("<form method='post'></form>"),
                input;
            form.attr({"action":"${pageContext.request.contextPath}/student/submit"});
            input = $("<input type='hidden'>");
            input.attr({"name":"json"});
            input.val(JSON.stringify(d));
            form.append(input);
            $(document.body).append(form);
            form.submit();

        });
    });



</script>

</body>
</html>