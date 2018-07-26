<%--
  Created by IntelliJ IDEA.
  User: yzq
  Date: 2018/7/25
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + application.getContextPath();

%>

<form action="<%=basePath%>/login.do" method="get">


    账号：<input type="text" name="account"><br>
    密码：<input type="password" name="pwd"> <br>


    <input type="submit" value="登录">

</form>

</body>
</html>
