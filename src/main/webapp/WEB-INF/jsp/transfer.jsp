<%--
  Created by IntelliJ IDEA.
  User: lxy_x
  Date: 2018/6/2
  Time: 1:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<!-- Head -->
<head>

    <title>银行管理系统</title>
    <link rel="shortcut icon" href="images/favicon.ico" />

    <link rel="bookmark"href="images/favicon.ico" />
    <!-- Meta-Tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- //Meta-Tags -->

    <!-- Style --> <link rel="stylesheet" href="css/login.css" type="text/css" media="all">



</head>
<!-- //Head -->

<!-- Body -->
<body>

<h1>欢迎光临XX银行</h1>

<div class="container w3layouts agileits">

    <div class="login w3layouts agileits">
        <h2>${sessionScope.user.realName} 用户，您好：</h2>
        <form method="post" onsubmit="return submitDo();">
            <input type="text" value="您当前的余额为：  ￥${money.remainSum}" disabled="disabled" id="max">
            <input type="text" Name="money" value="" placeholder="转账金额" id="money" onchange="check();">
            <input type="text" Name="toId" value="" placeholder="对方账户" id="toId" required="required">
            <input type="text" Name="toRealName" value="" placeholder="对方姓名" id="toRealName" required="required">
            <div class="send-button w3layouts agileits">
                <form>
                    <input type="submit" value="确认转账">
                </form>
            </div>
        </form>
        <div class="clear"></div>
    </div>
    <div class="register w3layouts agileits">
        <h2>友情提醒：</h2>
        <p>该操作不可逆！</p>
        <div class="send-button w3layouts agileits">

            <input type="submit" value="返回主页" onclick="window.location.href='myCount';">
            <br/>
            <br/>


        </div>
        <div class="clear"></div>
    </div>

    <div class="clear"></div>

</div>


<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
<script type="application/javascript">
    function check() {
        var max = parseFloat($("#max").val().split('￥')[1]);
        var money = $("#money").val();
        $("#money").val(money<max?money:max);
    }
    function submitDo(){


        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/transferMoney",
            dataType: 'json',
            data: {
                money: $("#money").val(),
                toId: $("#toId").val(),
                toRealName: $("#toRealName").val()
            },
            success: function (data) {
                var result = data['msg'];
                if ("1" == result) {
                    $("#idTag").html("转账成功～");
                } else {
                    $("#idTag").html("转账失败～");
                }
            }

        });
        return false;
    }
</script>
</body>
<!-- //Body -->

</html>
