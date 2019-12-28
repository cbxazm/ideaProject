<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
    <s:head></s:head>
</head>
<body>
<h1>struts的form标签</h1>
<%--struts不需要加项目名，它会自己给你加项目名，默认提交方式为post--%>
<s:form action="/user/register.action">
    <s:textfield name="username" label="用户名"></s:textfield>
    <s:password name="password" label="密码"></s:password>
    <s:textfield name="birthday" label="生日"></s:textfield>
    <%--<s:checkbox name="hobby"></s:checkbox>--%>
    <%--list使用的是OGNL表达式--%>
    <s:checkboxlist list="#{'玩耍':'玩耍','打游戏':'打游戏','打球':'打球'}" name="hobby" label="爱好"></s:checkboxlist>
     <s:radio list="#{'true':'已婚','false':'未婚'}" label="是否已婚" name="married"></s:radio>
    <s:submit value="注册"></s:submit>
</s:form>

<%--<hr>--%>
<%--<h1>html的原始标签</h1>--%>
<%--<s:fielderror></s:fielderror>--%>
    <%--<form action="${pageContext.request.contextPath}/user/register.action">--%>
             <%--用户名:<input type="text" name="username"><br>--%>
             <%--密码:<input type="password" name="password"><br>--%>
             <%--生日：<input type="text" name="birthday"><br>--%>
             <%--爱好:<input type="checkbox" name="hobby" value="写代码">写代码--%>
             <%--<input type="checkbox" name="hobby" value="打球">打球--%>
             <%--<input type="checkbox" name="hobby" value="游泳">游泳--%>
                    <%--<br>--%>
                <%--是否已婚:<input type="radio" name="marry" value="true">已婚--%>
                <%--<input type="radio" name="marry" value="false">未婚--%>
              <%--<br>--%>
        <%--<input type="submit" value="注册">--%>

    <%--</form>--%>
</body>
</html>
