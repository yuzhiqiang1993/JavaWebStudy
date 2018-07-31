<%--
  Created by IntelliJ IDEA.
  User: yzq
  Date: 2018/7/30
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>


    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>


    <script>
        $(function () {
            $("#ajaxBtn").on("click", function () {
                /*调登录*/
                loginWithAjax()
            })
            $("#getBtn").on("click", function () {
                /*调登录*/
                loginWiteGet()
            })
            $("#postBtn").on("click", function () {
                /*调登录*/
                loginWithPost()
            })

        })

        function loginWithAjax() {
            $.ajax({
                url: "<%=application.getContextPath()%>/login.do",
                data: {account: $("input[name=account]").val(), pwd: $("input[name=pwd]").val()},
                type: "POST",
                success: function (result) {
                    console.log(result)
                    $("#result").html(result.msg)

                },
                beforeSend: function () {
                    console.log("请求发送之前")
                },
                error: function () {
                    console.log("失败时调用")
                }
            })
        }

        function loginWiteGet() {

            $.get(
                "<%=application.getContextPath()%>/login.do",
                {account: $("input[name=account]").val(), pwd: $("input[name=pwd]").val()},
                function (data) {
                    console.log(result)
                    $("#result").html(data.msg)
                })
        }

        function loginWithPost() {
            $.post(
                "<%=application.getContextPath()%>/login.do",
                {account: $("input[name=account]").val(), pwd: $("input[name=pwd]").val()},
                function (data) {
                    console.log(result)
                    $("#result").html(data.msg)
                })

        }


    </script>


</head>
<body>


用户名：<input name="account" type="text"/>
<br>
密码：<input name="pwd" type="text">
<br>
<button id="ajaxBtn">ajax登录</button>
<button id="getBtn">get登录</button>
<button id="postBtn">post登录</button>


<hr>


登录结果：
<div id="result"></div>


</body>
</html>
