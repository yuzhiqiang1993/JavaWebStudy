<%--
  Created by IntelliJ IDEA.
  User: yzq
  Date: 2018/7/24
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>application对象</title>
</head>
<body>

<%
    application.setAttribute("", "");//新增属性
    application.getAttribute("");//获取属性
    application.getRealPath("");//获取指定虚拟路径的真实路径
    application.getResource("");//返回指定资源的url路径
    application.getContextPath();//获取项目的名称
%>

</body>
</html>
