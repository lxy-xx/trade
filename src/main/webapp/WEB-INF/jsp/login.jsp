<%--
  Created by IntelliJ IDEA.
  User: lxy_x
  Date: 2018/6/1
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<!-- Head -->
<head>

    <title>银行管理系统</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico"/>

    <link rel="bookmark" href="${pageContext.request.contextPath}/images/favicon.ico"/>
    <!-- Meta-Tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!-- //Meta-Tags -->

    <!-- Style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css" media="all">


</head>
<!-- //Head -->

<!-- Body -->
<body>

<h1>欢迎来到XX银行，请登录</h1>

<div class="container w3layouts agileits">

    <div class="login w3layouts agileits">
        <h2>登 录</h2>
        <form action="/login" method="post">
            <input type="text" Name="phoneNumber" placeholder="用户名/手机号" required="">
            <input type="password" Name="password" placeholder="密码" required="">
        </form>
        <ul class="tick w3layouts agileits">
            <li>
                <input type="checkbox" id="brand1" value="">
                <label for="brand1"><span></span>记住我</label>
            </li>
        </ul>
        <div class="send-button w3layouts agileits">
            <form>
                <input type="submit" value="登 录">
            </form>
        </div>
        <a href="#">记住密码?</a>

        <div class="clear"></div>
    </div>
    <div class="register w3layouts agileits">
        <h2>注 册</h2>
        <form action="#" method="post" onsubmit="return false;">
            <input type="number" maxlength="11" minlength="11" Name="phoneNumber" id="id" placeholder="手机号码"
                   required="required">
            <input type="text" Name="realName" placeholder="姓名" required="required">
            <input type="email" Name="email" placeholder="邮箱" required="required">
            <input type="password" Name="password" id="p1" placeholder="密码" required="required">
            <input type="password" Name="password2" id="p2" placeholder="确认密码" required="required">
            <div class="send-button w3layouts agileits">
                <input type="submit" value="免费注册"><br/>
                <span style="color: white" id="idTag"></span>
                <span style="color: white" id="pwdTag"></span>

            </div>
        </form>
        <div class="clear"></div>
    </div>

    <div class="clear"></div>

</div>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.md5.js"></script>
<script type="application/javascript">

    var idFlag = false;
    var pwdFlag = false;
    function checked() {

        return idFlag&&pwdFlag;
    }
    $("#p2").blur(function(){
        var p1 = $("#p1").val();
        var p2 = $("#p2").val();
        if(p1==p2){
            pwdFlag=true;
            $("#pwdTag").html("");
        }else {
            pwdFlag=false;
            $("#pwdTag").html("两次密码不一致～");
        }
    });

    $("#id").blur(function () {
        var id = $("#id").val().trim();
        if (id != "") {
            $.ajax({
                type: "GET",
                url: "${pageContext.request.contextPath}/rechecked",
                dataType: 'json',
                data: {username: id},
                success: function (data) {
                    var result = data['msg'];
                    if("1"==result){
                        idFlag=true;
                        $("#idTag").html("恭喜您，可以使用此昵称！");
                    }else {
                        idFlag=false;
                        $("#idTag").html("这个姓名已经被注册啦~");
                    }
                }

            });
        }
    });

</script>


</body>
<!-- //Body -->

</html>
