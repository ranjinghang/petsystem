<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单评价</title>
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
    <form action="/order/evaluate?{orderNo}" method="post" id="evaluate">
        <div class="form-group">
            <label for="eva">评价</label>
            <input type="text" class="form-control" name="eva" id="eva" placeholder="请输入评价内容">
        </div>

        <input id ="evaSubmit"type="submit" value="评价" class="btn btn-success btn-sm" class="text-left">
        <script>
            $("#evaluate").submit(function () {
                if ($("#eva").val() == '') {
                    alert("请填入评价内容！");
                    return false;
                }
            })

            $(function() {
                /** 验证文件是否导入成功  */
                $("#evaluate").ajaxForm(function(data){
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
