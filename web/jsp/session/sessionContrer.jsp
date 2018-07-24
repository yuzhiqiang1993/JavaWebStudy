<%--
  Created by IntelliJ IDEA.
  User: yzq
  Date: 2018/7/24
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%

    String account = request.getParameter("account");
    String pwd = request.getParameter("pwd");

    session.setAttribute("account", account);
    session.setAttribute("pwd", pwd);
    session.getCreationTime();//获取创建时间
    session.getId();//获取sessionid
//    session.invalidate();//取消session，使session不可用
//    session.removeAttribute("name");//移除某个属性

    request.getRequestDispatcher("result.jsp").forward(request, response);

%>