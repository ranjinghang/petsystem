<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>添加宠物</title>
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
    <form action="/pet/add" method="post" id="petAdd">
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

        <input type="submit" value="添加" class="btn btn-success btn-sm" class="text-left">
        <script>
            $("#petChange").submit(function () {
                if ($("#petName").val() == '' || $("#petSpeical").val() == '' || $("#petPrice").val() == '' ){
                    return false;
                }
            })

            $(function() {
                /** 验证文件是否导入成功  */
                $("#petAdd").ajaxForm(function(data){
                    setMessage(data);
                    alert(data);
                });
            });
        </script>
    </form>
</div>
</body>
</html>