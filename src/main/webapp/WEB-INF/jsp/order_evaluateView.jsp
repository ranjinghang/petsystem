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
    <form action="#" method="post" id="evaluate">
        <div class="form-group">
            <label for="eva">评价</label>
            <input type="text" class="form-control" name="eva" id="eva" placeholder="请输入评价内容">
        </div>

        <input id ="evaSubmit" type="button" value="评价" class="btn btn-success btn-sm" class="text-left">
        <script>
            $("#evaSubmit").click(function () {
                var dataStr = {
                    "eva" : $("#eva").val()
                };
                if ($("#eva").val() == '') {
                    alert("请填入评价内容！" );
                    return false;
                }else {

                    $.ajax({
                        type: "POST",//方法类型
                        dataType: "json",//预期服务器返回的数据类型
                        url: "/order/evaluate?orderNo=${orderNo}",//要响应的url
                        data: JSON.stringify(dataStr),
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
                    });
                }
            })

        </script>
    </form>
</div>
</body>
</html>
