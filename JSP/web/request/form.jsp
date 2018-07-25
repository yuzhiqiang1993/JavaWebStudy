<%--
  Created by IntelliJ IDEA.
  User: yzq
  Date: 2018/7/24
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>request form表单</title>
</head>
<body>

<form action="requestController.jsp" method="get">

    姓名:<input name="userName"><br>
    年龄：<input name="age"> <br>
    爱好：<input type="checkbox" name="hobby" value="吃">吃
    <input type="checkbox" name="hobby" value="喝">喝
    <input type="checkbox" name="hobby" value="玩">玩
    <input type="checkbox" name="hobby" value="乐">乐

    <br>

    <input type="submit" value="提交">


</form>

</body>
</html>
