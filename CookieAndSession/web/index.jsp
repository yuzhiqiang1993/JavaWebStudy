<%--
  Created by IntelliJ IDEA.
  User: yzq
  Date: 2018/7/27
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>

<%
    String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + application.getContextPath();

    /*获取request中的cookie*/
    Cookie[] cookies = request.getCookies();
    String cookieAccount = "";

    if (cookies != null) {

        for (Cookie cookie :
                cookies) {
            System.out.println("cookie:  " + cookie.getName() + ":" + cookie.getValue());

            /*如果cookie中存储的有account，取出该值 */
            if (cookie.getName().equals("account")) {
                cookieAccount = cookie.getValue();
            }

        }
    }


%>

<form action="<%=application.getContextPath()%>/login">

    <%--将cookie中携带的account值赋值给value--%>
    <input name="account" value="<%=cookieAccount%>"><br>
    <input name="pwd"><br>
    记住密码：<input type="checkbox" name="remember"> <br>
    <input type="submit" value="登录">


</form>

</body>
</html>
