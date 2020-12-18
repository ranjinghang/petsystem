<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>宠物信息修改</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <script src="/static/js/jquery-3.2.1.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="http://malsup.github.com/jquery.form.js" /></script>
    <style>
        .form-group {
            margin-bottom: 0;
        }
    </style>

    <script>
        $(function () {
            $('#header').load('/admin_header.html');
        })
    </script>
</head>
<body background="/static/img/sky.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">

<div id="header"></div>
<div style="position: relative;padding-top: 60px; width: 80%;margin-left: 10%">
    <form action="#" method="post" id="petChange">
        <div class="form-group">
            <label for="petName">宠物名称</label>
            <input type="text" class="form-control" name="petName" id="petName" placeholder="请输入宠物名称">
        </div>
        <div class="form-group">
            <label for="petSpeical">宠物种类</label>
            <input type="text" class="form-control" name="petSpeical" id="petSpeical" placeholder="请输入宠物种类">
        </div>
        <div class="form-group">
            <label for="petPrice">宠物价格</label>
            <input type="text" class="form-control" name="petPrice" id="petPrice" placeholder="请输入宠物价格">
        </div>

        <input id="changeSubmit" type="button" value="修改" class="btn btn-success btn-sm" class="text-left">
        <script>
            $("#changeSubmit").click(function () {
                var dataStr = {
                    "petName" : $("#petName").val(),
                    "petSpeical" : $("#petSpeical").val(),
                    "petPrice" : $("#petPrice").val()
                };
                if ($("#petName").val() == '' || $("#petSpeical").val() == '' || $("#petPrice").val() == '') {
                    alert("请填入参数！" );
                    return false;
                }else {
                    $.ajax({
                        type: "POST",//方法类型
                        dataType: "json",//预期服务器返回的数据类型
                        url: "/pet/change?petId=${petId}",//要响应的url
                        data: JSON.stringify(dataStr),
                        async: false,   //false为同步，true为异步
                        contentType: "application/json",
                        success: function (data) {
                            //表示注册不成功，由于控制器返回的是map，所以就可以用data[key]
                            alert(data.msg);
                            window.location.href = "/pet/listView?type=1";
                        },
                        error: function (data) {
                            alert(data);
                        }
                    });
                }
            })
        </script>
    </form>
</div>
</body>
</html>