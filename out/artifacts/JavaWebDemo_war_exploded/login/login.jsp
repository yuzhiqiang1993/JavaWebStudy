<%--
  Created by IntelliJ IDEA.
  User: yzq
  Date: 2018/7/24
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>

<%

    /*http://localhost:8080/JavaWebDemo/loginServlet*/

    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getServletContext().getContextPath();


%>


<%=application.getContextPath()%>

<body>
<form action="<%=basePath%>/loginServlet" method="post">

    账号:<input name="account"><br>
    密码：<input name="pwd"> <br>

    <br>

    <input type="submit" value="提交">


</form>
</body>
</html>
