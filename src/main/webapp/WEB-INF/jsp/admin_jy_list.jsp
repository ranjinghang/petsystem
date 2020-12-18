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
            <c:forEach items="${jyListVOList}" var="jyVO">
                <tr>
                    <td><c:out value="${jyVO.petName}"></c:out></td>
                    <td><c:out value="${jyVO.orderName}"></c:out></td>
                    <td><c:out value="${jyVO.petSpecial}"></c:out></td>
                    <td><c:out value="${jyVO.num}"></c:out></td>
                    <td><c:out value="${jyVo.createTime}"></c:out></td>

                    <c:if test="${jyVO.agree eq 0}">
                        <td><a onclick="jy_agree(${jyVO.jyId})">
                            <button type="button" class="btn btn-danger btn-xs">同意申请</button>
                        </a></td>
                    </c:if>
                    <c:if test="${jyVO.agree eq 1}">
                        <td>已同意</td>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>
<script>
    function jy_agree(no) {
        $.ajax({
            type: "GET",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "/jy/agree?jyId=" + no,//要响应的url
            data: null,
            async: false,   //false为同步，true为异步
            contentType: "application/json",
            success: function (data) {
                //表示注册不成功，由于控制器返回的是map，所以就可以用data[key]
                alert(data.msg);
                window.location.href = "/jy/listView";
            },
            error: function (data) {
                alert(data);
            }
        })
    }
</script>
</body>
</html>
