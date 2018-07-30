<%--
  Created by IntelliJ IDEA.
  User: YZQ
  Date: 2018/7/29
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--JSTL 核心标签--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--JSTL 格式化标签--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--JSTL SQL标签--%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%--JSTL XMLb标签--%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%--JSTL 函数标签--%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<html>
<head>
    <title>JSTL</title>
</head>
<body>


<%--将值保存到指定作用域中--%>
<c:set var="userName" value="yzq" scope="page"></c:set>

<br>
<%--取值--%>
out标签取值：<c:out value="${userName}"></c:out>
<br>

<%--删除userName的值--%>
<c:remove var="userName"></c:remove>

<br>
EL取值：${userName}
<br>

<c:set var="age" scope="page" value="25"></c:set>

<c:if test="${age>20}">

    <span>奔三的人了</span>

</c:if>
<br>
<c:set var="age" scope="page" value="40"></c:set>
<c:choose>

    <%--符合该条件时执行--%>
    <c:when test="${age>20&&age<30}">
        <span>奔三的人了</span>
    </c:when>

    <%--符合该条件时执行--%>
    <c:when test="${age<20}">
        <span>还是小鲜肉</span>

    </c:when>

    <%--之前条件都不满足时，执行这个--%>
    <c:otherwise>

        <span>可以考虑养生了</span>

    </c:otherwise>
</c:choose>
<br>

<%--迭代标签 用于迭代集合--%>
<c:forEach items="${users}" var="user" begin="2" end="6" step="2" varStatus="userStatus">


    <hr>
    <span>${user.name}</span>:<span>${user.age}</span><br>

    计数：${userStatus.count} <br>
    步长：${userStatus.step} <br>
    开始位置： ${userStatus.begin} <br>
    结束位置：${userStatus.end} <br>
    下标：${userStatus.index} <br>
    是否是第一个：${userStatus.first} <br>
    是否是最后一个：${userStatus.last}<br>


</c:forEach>


</body>
</html>
