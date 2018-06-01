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
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico" />

    <link rel="bookmark"href="${pageContext.request.contextPath}/images/favicon.ico" />
    <!-- Meta-Tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- //Meta-Tags -->

    <!-- Style --> <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css" media="all">



</head>
<!-- //Head -->

<!-- Body -->
<body>

<h1>欢迎来到XX银行，请登录</h1>

<div class="container w3layouts agileits">

    <div class="login w3layouts agileits">
        <h2>登 录</h2>
        <form action="#" method="post">
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
        <form action="#" method="post">
            <input type="text" Name="phoneNumber" placeholder="手机号码" required="">
            <input type="text" Name="realName" placeholder="姓名" required="">
            <input type="text" Name="email" placeholder="邮箱" required="">
            <input type="password" Name="password" placeholder="密码" required="">
            <input type="password" Name="password2" placeholder="确认密码" required="">

        </form>
        <div class="send-button w3layouts agileits">
            <form>
                <input type="submit" value="免费注册">
            </form>
        </div>
        <div class="clear"></div>
    </div>

    <div class="clear"></div>

</div>


</body>
<!-- //Body -->

</html>
