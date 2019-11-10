<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <script>
        window.onload = function () {
            var otxt = document.getElementById("txt");
            var maxW = 500;
            var minW = 200;
            var timer = null;
            otxt.onfocus = function () {
                timer = setInterval(function () {
                    if (otxt.offsetWidth >= maxW) {
                        clearInterval(timer);
                    } else {
                        otxt.style.width = (otxt.offsetWidth + 2) + "px";
                    }
                },0)
            }
            otxt.onblur = function () {
                timer = setInterval(function () {
                    if (otxt.offsetWidth >= minW) {
                        otxt.style.width = (otxt.offsetWidth - 4) + "px";
                    } else {
                        clearInterval(timer);
                    }
                }, 0)
            }
        }
    </script>
</head>
<style type="text/css">
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
    .sub-header {
        padding-bottom: 10px;
        border-bottom: 1px solid #eee;
    }
</style>
<body>
    <%@include file="head.jsp"%>
    <%@include file="leaf.jsp"%>
<div class=" col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 table-responsive main panel panel-info">
    <h2 class="sub-header">Section title</h2>
    <div id="navbar" class="navbar-collapse collapse">

        <form class="navbar-form navbar-right">
            <input id="txt" type="text" class="form-control" placeholder="Search...">
            <input type="submit" class="btn btn-primary" value="搜索">
        </form>
    </div>
    <table class="table table-hover table-striped">
        <a href="add.jsp"><button type="button" class="btn btn-warning">添加</button></a>
        <tr>
            <th class="active">aaaaa</th>
            <th class="success">BBBBB</th>
            <th class="warning">CCCCC</th>
            <th class="danger">DDDDDDDDD</th>
            <th class="info">EEEEEEE</th>
            <th>操作</th>
        </tr>
        <tr>
            <td class="active">aaaaa</td>
            <td class="success">BBBBB</td>
            <td class="warning">CCCCC</td>
            <td class="danger">DDDDDDDDD</td>
            <td class="info">EEEEEEE</td>
            <td >
                <a href="update.jsp"><button type="button" class="btn btn-info">修改</button></a>
                <a href=""><button type="button" class="btn btn-danger">删除</button></a>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
