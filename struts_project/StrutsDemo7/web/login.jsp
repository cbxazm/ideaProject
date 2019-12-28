<%--<%@ page import="java.util.ResourceBundle" %>--%>
<%--<%@ page import="java.util.Locale" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<%--%>

    <%--Locale locale=Locale.getDefault();//获取默认的国家语言--%>
    <%--ResourceBundle bundle =ResourceBundle.getBundle("resources.message",locale);--%>
<%--%>--%>
<%--<%=locale%>--%>
 <%--<form action="${pageContext.request.contextPath}/login">--%>
     <%--<%=bundle.getString("login.username")%><input type="text" name="username"><br>--%>
     <%--<%=bundle.getString("login.password")%><input type="password" name="password"><br>--%>
     <%--<input type="submit" value="  <%=bundle.getString("login.submit")%>">--%>
 <%--</form>--%>
<form action="${pageContext.request.contextPath}/login">
    <s:text name="login.username"/><input type="text" name="username"><br>
    <s:text name="login.password"/><input type="password" name="password"><br>
    <input type="submit" value='<s:text name="login.submit"/>'>
</form>
     </body>
</html>
