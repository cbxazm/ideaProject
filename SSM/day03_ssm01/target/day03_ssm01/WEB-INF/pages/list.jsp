<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>查询所有的用户</h1>
<%--${list}--%>
<c:forEach items="${list}" var="account">
    ${account.money}
</c:forEach>
</body>
</html>
