<%--
  Created by IntelliJ IDEA.
  User: yzq
  Date: 2018/7/24
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<%

    String account;
    if (request.getParameter("fig").equals("1")) {
        account = (String) session.getAttribute("account");
%>
登录成功 <%=account%>
<%
    } else {
%>
登录失败
<%
    }


%>


</body>
</html>
