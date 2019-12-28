<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    Locale locale=Locale.getDefault();//获取默认的国家语言
    ResourceBundle bundle =ResourceBundle.getBundle("resources.message",locale);
%>
<%=locale%>
 <form action="${pageContext.request.contextPath}/login">
     <%=bundle.getString("login.username")%><input type="text" name="username"><br>
     <%=bundle.getString("login.password")%><input type="password" name="password"><br>
     <input type="submit" value="  <%=bundle.getString("login.submit")%>">
 </form>
</body>
</html>
