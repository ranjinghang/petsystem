<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>全部订单</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <script src="/static/js/jquery-3.2.1.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <script>
        $(function () {
            $('#header').load('/reader_header.html');
        })
    </script>
</head>
<body background="/static/img/lizhi.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">

<div id="header"></div>
<div style="position: relative;top: 10%">
    <c:if test="${!empty succ}">
        <div class="alert alert-success alert-dismissable">
            <button type="button" class="close" data-dismiss="alert"
                    aria-hidden="true">
                &times;
            </button>
                ${succ}
        </div>
    </c:if>
    <c:if test="${!empty error}">
        <div class="alert alert-danger alert-dismissable">
            <button type="button" class="close" data-dismiss="alert"
                    aria-hidden="true">
                &times;
            </button>
                ${error}
        </div>
    </c:if>
</div>
<div class="panel panel-default" style="width: 90%;margin-left: 5%">
    <div class="panel-heading" style="background-color: #fff">
        <h3 class="panel-title">
            全部订单
        </h3>
    </div>
    <div class="panel-body">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>订单名</th>
                <th>购买时间</th>
                <th>购买数据</th>
                <th>评价</th>
                <th>寄养操作</th>
                <th>售后操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${orderList}" var="order">
                <tr>
                    <td><c:out value="${order.orderName}"></c:out></td>
                    <td><c:out value="${order.createTime}"></c:out></td>
                    <td><c:out value="${order.num}"></c:out></td>
                    <td>
                        <c:if test="${empty order.evaluate}">
                            <a href="/order/evaluateView?orderNo=<c:out value="${order.orderNo}"></c:out>">
                                <button type="button" class="btn btn-danger btn-xs">评价</button>
                            </a>
                        </c:if>
                        <c:if test="${not empty order.evaluate}">
                            <c:out value="${order.evaluate}"></c:out>
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${empty order.jyId}">
                            <a onclick="jy_insert(${order.orderNo})">
                                <button type="button" class="btn btn-danger btn-xs">申请寄养</button>
                            </a>
                        </c:if>
                        <c:if test="${not empty order.jyId}">
                            <c:if test="${order.agree eq 0}">
                                等待管理员同意
                            </c:if>
                            <c:if test="${order.agree eq 1}">
                                已寄养
                            </c:if>
                        </c:if>
                    </td>
                    <td>
                    <a href="/order/delete?orderNo=<c:out value="${order.orderNo}"></c:out>">
                        <button type="button" class="btn btn-danger btn-xs">售后</button>
                    </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script>
    function jy_insert(no) {
        $.ajax({
            type: "GET",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "/Jy/insert?orderNo=" + no,//要响应的url
            data: null,
            async: false,   //false为同步，true为异步
            contentType: "application/json",
            success: function (data) {
                //表示注册不成功，由于控制器返回的是map，所以就可以用data[key]
                alert(data.msg);
                window.location.href = "/order/listView";
            },
            error: function (data) {
                alert(data);
            }
        })
    }
</script>
</body>

</html>
