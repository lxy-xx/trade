<%--
  Created by IntelliJ IDEA.
  User: lxy_x
  Date: 2018/6/2
  Time: 0:59
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

<h1>欢迎光临XX银行</h1>

<div class="container w3layouts agileits">

    <div class="login w3layouts agileits">
        <h2>XXX 用户，您好：</h2>

        <input type="text" Name="phoneNumber" value="您当前的余额为：  ￥300.00" disabled="disabled">
        <input type="text" Name="phoneNumber" value="当前七日年化率：  　3.95%" disabled="disabled">

        <div class="clear"></div>
    </div>
    <div class="register w3layouts agileits">
        <h2>请选择您的操作：</h2>

        <div class="send-button w3layouts agileits">
            <form>
                <input type="submit" value="存钱">
                <br/>
                <br/>
                <input type="submit" value="取钱">
                <br/>
                <br/>
                <input type="submit" value="账户汇款">
            </form>
        </div>
        <div class="clear"></div>
    </div>

    <div class="clear"></div>

</div>


</body>
<!-- //Body -->

</html>
