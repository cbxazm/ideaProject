<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.User" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        List list=new ArrayList();
        list.add(new User("张三",23,new Date()));
        list.add(new User("李四",24,new Date()));
        list.add(new User("王五",25,new Date()));
          request.setAttribute("list",list);
    %>
<table border="1" cellspacing="0" cellpadding="">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>生日</th>
    </tr>
     <%--数据行--%>
    <c:forEach items="${list}" var="user" varStatus="s">
               <c:if test="${s.count%2==0}">
                   <tr bgcolor="#87ceeb">
                       <th>${s.count}</th>
                       <th>${user.name}</th>
                       <th>${user.age}</th>
                       <th>${user.bitStr}</th>
                   </tr>
               </c:if>
        <c:if test="${s.count%2!=0}">
            <tr bgcolor="orange">
                <th>${s.count}</th>
                <th>${user.name}</th>
                <th>${user.age}</th>
                <th>${user.bitStr}</th>
            </tr>
        </c:if>

    </c:forEach>
</table>
</body>
</html>
