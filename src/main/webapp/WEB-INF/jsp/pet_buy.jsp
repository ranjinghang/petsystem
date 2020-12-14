<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书信息添加</title>
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
            $('#header').load('/reader_header.html');
        })
    </script>
</head>
<body background="/static/img/sky.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">

<div id="header"></div>
<div style="position: relative;padding-top: 60px; width: 80%;margin-left: 10%">
    <form action="/pet/buy?{petId}" method="post" id="buypet">
        <div class="form-group">
            <label for="count">数量</label>
            <input type="text" class="form-control" name="count" id="count" placeholder="请输入数量">
        </div>

        <input id ="buypetSubmit"type="submit" value="添加" class="btn btn-success btn-sm" class="text-left">
        <script>
            $("#addbook").submit(function () {
                if ($("#count").val() == '') {
                    alert("请填入数量！");
                    return false;
                }
            })

            $(function() {
                /** 验证文件是否导入成功  */
                $("#buypet").ajaxForm(function(data){
                    setMessage(data);
                    alert(data);
                });
            });
        </script>
    </form>
</div>
<script type="text/javascript">

</script>
</body>
</html>
