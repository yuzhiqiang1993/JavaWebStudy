<%--
  Created by IntelliJ IDEA.
  User: yzq
  Date: 2018/7/31
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>


    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>


    <script>

        $(function () {
            $("button").on("click", function () {
                doLogin();

            })
        })


        function doLogin() {
            $.post(
                "<%=application.getContextPath()%>/login.do",
                {"account": $("input[name=account]").val(), "pwd": $("input[name=pwd]").val()},
                function (data) {

                    if (data.fig=="1"){

                        $(location).prop('href', "<%=application.getContextPath()%>/index.jsp")
                    }

                    $("span").html(data.msg)

                }
            )
        }


    </script>


    <style>

        span {
            color: red;
            font-size: 14px;
        }

    </style>
</head>
<body>

账号：<input name="account" type="text"><br>
密码：<input name="pwd" type="text"><br>
<button>登录</button>

<span></span>

</body>
</html>
