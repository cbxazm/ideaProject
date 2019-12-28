<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
    <s:head></s:head>
</head>
<body>
<%--可以看到出错误明细--%>
<s:debug></s:debug>
<s:actionerror></s:actionerror>
   <s:form action="/stu/add.action">
         <s:textfield name="username" label="用户名"></s:textfield>
         <s:textfield name="age" label="年龄"></s:textfield>
         <s:textfield name="email" label="邮箱"></s:textfield>
       <s:password name="password" label="密码"></s:password>
        <s:textfield name="repassword" label="确认密码"></s:textfield>
         <s:textfield name="score" label="成绩"></s:textfield>
         <s:textfield name="url" label="个人主页"></s:textfield>
       <s:radio list="{'男','女'}" name="gender" label="性别"></s:radio>
       <s:submit value="提交"></s:submit>
   </s:form>
</body>
</html>
