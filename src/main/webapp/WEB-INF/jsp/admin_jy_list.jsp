<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>全部申请单信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <script src="/static/js/jquery-3.2.1.js"></script>
    <script src="/static/js/bootstrap.min.js" ></script>
    <script>
        $(function () {
            $('#header').load('/admin_header.html');
        })
    </script>
</head>
<body background="/static/img/book1.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">

<div id="header"></div>
<div class="panel panel-default" style="width: 90%;margin-left: 5%">
    <div class="panel-heading" style="background-color: #fff">
        <h3 class="panel-title">
            全部申请单
        </h3>
    </div>
    <div class="panel-body">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>宠物名</th>
                <th>订单名</th>
                <th>宠物种类</th>
                <th>购买数量</th>
                <th>创建时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${petList}" var="pet">
                <tr>
                    <td><c:out value="${pet.petName}"></c:out></td>
                    <td><c:out value="${pet.petSpecial}"></c:out></td>
                    <td><c:out value="${pet.petPrice}"></c:out></td>

                    <td><a href="/pet/changeView?petId=<c:out value="${pet.petId}"></c:out>">
                        <button type="button" class="btn btn-danger btn-xs">修改</button>
                    </a></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
