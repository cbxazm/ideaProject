
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <div>${user.username},欢迎您</div>
  <div align="center">
    <a href="${pageContext.request.contextPath}/userListServlet" style="text-decoration: none;font-size: 33px">

 查询所有的用户
    </a>
  </div>
  </body>
</html>
