<%--
  Created by IntelliJ IDEA.
  User: yzq
  Date: 2018/8/1
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>session</title>
</head>
<body>

<%

    session.setAttribute("user", "yzq");
    session.setAttribute("user", "123");
    session.removeAttribute("user");
    session.invalidate();
%>
</body>
</html>
