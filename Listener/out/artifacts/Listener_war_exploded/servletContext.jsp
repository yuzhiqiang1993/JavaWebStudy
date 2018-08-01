<%--
  Created by IntelliJ IDEA.
  User: yzq
  Date: 2018/8/1
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>servletContext</title>

    <%
        /*application实际上就是ServletContext的实例*/
    application.setAttribute("user","111");//新增属性
    application.setAttribute("user","yzq");//修改属性
    application.removeAttribute("user");//移除属性
    %>

</head>
<body>

</body>
</html>
