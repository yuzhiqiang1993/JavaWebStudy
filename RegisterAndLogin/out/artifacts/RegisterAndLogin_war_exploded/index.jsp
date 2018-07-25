<%--
  Created by IntelliJ IDEA.
  User: yzq
  Date: 2018/7/25
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>


<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + application.getContextPath();

%>


<form action="<%=basePath%>/register.do" method="post">


    账号：<input type="text" name="account"><br>
    密码：<input type="password" name="pwd"> <br>
    头像：<input type="file" name="img"><br>
    性别：<input type="radio" name="gender" value="男">男
    <input type="radio" name="gender" value="女">女
    爱好：<input type="checkbox" name="hobbies" value="唱歌"> 唱歌
    <input type="checkbox" name="hobbies" value="看电影"> 看电影
    <input type="checkbox" name="hobbies" value="玩游戏"> 玩游戏
    <input type="checkbox" name="hobbies" value="敲代码"> 敲代码

    <br>


    <input type="submit" value="注册">

</form>

</body>
</html>
