<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
           <%--if标签--%>
      <c:if test="true">
         <h1>真的</h1>
      </c:if>
<%
  //判断request域中的一个list集合是否为空，如果不为null则显示遍历集合
    List list=new ArrayList();
    list.add("aaa");
    request.setAttribute("list",list);
%>
<c:if test="${not empty list}">
          遍历集合.....
</c:if>
</body>
</html>
