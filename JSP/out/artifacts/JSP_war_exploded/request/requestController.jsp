<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: yzq
  Date: 2018/7/24
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>request内置对象</title>
</head>
<body>

<%


    request.setAttribute("name","喻志强");
    request.setCharacterEncoding("utf-8");


    Enumeration<String> headers = request.getHeaderNames();


    while (headers.hasMoreElements()) {

        String headerName = headers.nextElement();

        String headerValue = request.getHeader(headerName);
        System.out.println(headerName + " : " + headerValue);
%>

<span>
    <%=headerName%>
    :
    <%=headerValue%>

</span>
<br>

<% }%>

<hr>

<%
    request.setAttribute("name","喻志强");//忘request对象中存储一个值  key-value的形式
    request.setCharacterEncoding("utf-8");//设置编码格式

    request.getParameter("");//获取提交的指定参数的值
    request.getParameterNames();//返回请求中所有参数的集合
    request.getParameterValues("");//获取包含指定参数的所有值的数组
    request.getAttributeNames();//获取所有属性名称集合
    request.getAttribute("name");//获取指定属性的属性值,如果不存在返回null
    request.getCharacterEncoding();//获取编码格式
    request.getProtocol();//获取HTTP使用的协议
    request.getServletPath();//获取用户提交信息的页面的路径
    request.getMethod();//获取用户提交的方式（GET/POST 等）
    request.getHeaderNames();//返回所有HTTP头的名称集合
    request.getHeader("");//获取header中指定属性的值
    request.getRemoteAddr();//获取用户的ip地址
    request.getRemoteHost();//获取用户的主机名
    request.getServerName();//获取服务器的名称
    request.getServerPort();//获取服务器端口号
    request.getCookies();//返回客户端所有的Cookie的数组
    request.getSession();//返回request对应的session对象，如果没有，则创建一个
    request.getInputStream();//返回请求的输入流
    request.getContextPath();//返回request URI中指明的上下文路径

  //  request.getRequestDispatcher("result.jsp").forward(request,response);//请求转发

    String userName = request.getParameter("userName");
    String age = request.getParameter("age");
    String[] hobbies = request.getParameterValues("hobby");

    int serverPort = request.getServerPort();
    String serverName = request.getServerName();

%>

serverPort:<%=serverPort%>
<br>
serverName:<%=serverName%>
<br>
<%=request.getServletContext().getContextPath()%>


<hr>
提交的用户名：<%=userName%><br>
提交的年龄：<%=age%><br>
提交的爱好：
<%
    for (int i = 0; i < hobbies.length; i++) {
        out.print(hobbies[i] + " ");
    }


%>


</body>
</html>
