<%--
  Created by IntelliJ IDEA.
  User: yzq
  Date: 2018/7/24
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>responseController</title>
</head>
<body>

<%
    response.getOutputStream();//返回一个响应二进制的输出流
    response.getWriter();//返回可以输出字符的对象
    response.sendRedirect("");//页面重定向
    response.setContentLength(1000);//设置响应头长度
    response.setContentType("");//设置响应的MIME类型
    response.getCharacterEncoding();//获取编码格式
    response.addCookie(new Cookie("",""));//添加Cookie
    response.setHeader("Con","");//设置header
    response.setStatus(200);//设置响应码





    String account = request.getParameter("account");
    String pwd = request.getParameter("pwd");

    if (account.equals("yzq")&&pwd.equals("123")){
      response.getWriter().write("登录成功");
    }else {
        response.getWriter().write("账号或密码错误");
    }


   // response.sendRedirect(request.getContextPath());

%>

</body>
</html>
