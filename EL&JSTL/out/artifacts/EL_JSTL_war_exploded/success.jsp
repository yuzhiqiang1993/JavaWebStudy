<%--
  Created by IntelliJ IDEA.
  User: YZQ
  Date: 2018/7/29
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>


<%--传统的取值方式--%>

<h1>登录成功</h1>


<h3>传统的取值方式</h3>
用户名：<%=request.getAttribute("account")%>
<br>
密码：<%=request.getAttribute("pwd")%>


<h3>EL表达式取值</h3>

<%--使用EL表达式取值--%>
用户名：
requestScope:
pageScope${pageScope.account}
${requestScope.account} //指定从request作用域中查找account
sessionScope${sessionScope.account}
applicationScope${applicationScope.account}
<br>
密码: ${pwd}
</body>
</html>
