<%@ page contentType="text/html;charset=UTF-8"  language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basepath"  value="${pageContext.request.contextPath}/"/>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="${basepath}static/css/bootstrap.min.css">
    <script src="${basepath}static/js/jquery-3.2.1.js"></script>
    <script src="${basepath}static/js/bootstrap.min.js" ></script>
    <script src="${basepath}static/js/js.cookie.js"></script>
    <style>
        #login{
            height: 50%;
            width: 28%;
            margin-left: auto;
            margin-right: auto;
            margin-top: 5%;
            display: block;
            position: center;
        }

        .form-group {
            margin-bottom: 0;
        }
        * {
            padding:0;
            margin:0;
        }
    </style>
</head>
<body background="${basepath}static/img/timg.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">

<h2 style="text-align: center; color: white; font-family: '华文行楷'; font-size: 500%">宠物管理</h2>

<div class="panel panel-default" id="login">
    <div class="panel-heading" style="background-color: #fff">
        <h3 class="panel-title">请注册</h3>
    </div>
    <div class="panel-body">
        <div class="form-group">
            <label for="id">账号</label>
            <input type="text" class="form-control" id="id" placeholder="请输入账号">
        </div>
        <div class="form-group">
            <label for="passwd">密码</label>
            <input type="password" class="form-control" id="passwd" placeholder="请输入密码">
        </div>
        <div class="form-group">
            <label>用户性质</label>
            <input name="resultName" type="radio" checked value="2" id="admin" /><label for="admin">管理员</label>
            <input name="resultName" type="radio" value="1" id="user" /><label for="user">用户</label>
        </div>

        <p style="text-align: right;color: red;position: absolute" id="info"></p><br/>
        <button id="register"  class="btn btn-primary  btn-block">注册
        </button>
    </div>
</div>
<script>
    $("#register").click(function () {
        var id =$("#id").val();
        var passwd=$("#passwd").val();
        var type=$('input:radio:checked').val();
        var dataStr = {
            "userId":id ,
            "password": passwd,
            "type": type
        };
        if (id == '') {
            $("#info").text("提示:账号不能为空");
        }
        else if( passwd ==''){
            $("#info").text("提示:密码不能为空");
        }
        else {
            $.ajax({
                type: "POST",
                url: "/login/register",
                contentType: "application/json;charset=UTF-8",
                data: JSON.stringify(dataStr),
                dataType: "json",
                success: function(data) {
                    if (data.stateCode.trim() === "0") {
                        $("#info").text("提示:账号或密码错误！");
                    } else if (data.stateCode.trim() === "1") {
                        $("#info").text("提示:注册成功，跳转中...");
                        window.location.href="/index";
                    }
                }
            });
        }
    })

</script>
</div>

</body>
</html>
