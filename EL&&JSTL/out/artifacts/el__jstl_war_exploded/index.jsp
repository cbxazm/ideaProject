
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
 <%
      pageContext.setAttribute("msg","hello");
 %>
  <%=pageContext.getAttribute("msg")%>
  </body>
</html>
