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

<div style="padding: 20px 550px 10px">
    <form method="post" action="#" class="form-inline" id="searchform">
        <div class="input-group">
            <input type="text" placeholder="订单名" class="form-control" id="search" name="searchWord"
                   class="form-control">
            <span class="input-group-btn">
                <input type="submit" value="搜索" class="btn btn-default">
            </span>
        </div>
    </form>
    <script>
        $("#searchform").submit(function () {
            var val = $("#search").val();
            if (val == '') {
                alert("请输入关键字");
                return false;
            }
        })
    </script>
</div>
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
                <td>
                    <td><c:out value="${order.orderName}"></c:out></td>
                    <td><c:out value="${order.createTime}"></c:out></td>
                    <td><c:out value="${order.num}"></c:out></td>
                    <td><c:out value="${order.evaluate}"></c:out></td>
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
                            <a href="/Jy/insert?orderNo=<c:out value="${order.orderNo}"></c:out>">
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
                    </td>
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
</body>
</html>
