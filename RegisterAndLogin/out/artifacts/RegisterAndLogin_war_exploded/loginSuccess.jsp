<%@ page import="data.UserBean" %>
<%--
  Created by IntelliJ IDEA.
  User: yzq
  Date: 2018/7/25
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>

    <style>
        img {
            width: 300px;
            height: 300px;
            margin: auto;

        }

    </style>
</head>
<body>

<%

    /*获取session中的user*/
    UserBean user = (UserBean) request.getSession().getAttribute("user");

    /*注意这里我们拿到的是磁盘绝对路径，我们要转为相对路径*/
    String imgPath = user.getImg();

    int index = imgPath.lastIndexOf("\\");

    String relativePath = application.getContextPath() + "/upload" + imgPath.substring(index);

    System.out.println("相对路径：" + relativePath);
%>


<h1>登录成功,账号为：<%=user.getAccount()%>
</h1>

<img src="<%=relativePath%>">

</body>
</html>
