<%--
  Created by IntelliJ IDEA.
  User: yzq
  Date: 2018/7/24
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="exception/error.jsp" %>
<html>
<head>
    <title>JSP基础语法</title>
</head>
<body>


<%--JSP声明语法--%>

<%!

    /*在这里声明的变量和方法是全局的,可以在页面的任意地方使用*/
    String name = "喻志强";
    int age = 25;

    String getName() {
        return name;
    }

%>


<%--JSP程序脚本--%>

<%
    /*
     * 这里可以写变量声明，表达式，程序逻辑等
     * 是局部的，相当于Java中的普通方法
     * */
    String name = "yzq";
    int age = 23;
    if (age > 20) {
%>

<span>奔三的人了</span>
<%

} else {
%>

<span>奔二的人了</span>
<%
    }
%>


<%--JSP输出表达式--%>

<%=getName() %>

</body>
</html>
