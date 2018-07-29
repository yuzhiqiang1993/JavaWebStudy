<%--
  Created by IntelliJ IDEA.
  User: YZQ
  Date: 2018/7/29
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式</title>
</head>
<body>


<form action="<%=application.getContextPath()%>/el" method="get">


    用户名：<input name="account" type="text"/>
    <br>
    密码：<input name="pwd" type="text">
    <br>
    <input type="submit" value="提交">

</form>


</body>
</html>
