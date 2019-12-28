<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--导入css的全局样式--%>
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <%--jquery导入--%>
    <script src="./js/jquery-2.1.0.min.js"></script>
    <%--到诶bootstrap的js文件--%>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
<style type="text/css">
 body{
     background-image: url(./img/1.jpg);
 }
   .aa{
       /*background: red;*/
       width: 100px;
       margin: 0 auto;
   }
</style>
    <script>
        window.onload=function () {
            //切换验证码
            var vecode=document.getElementById("vecode").onclick=function () {
                this.src="${pageContext.request.contextPath}/servlet.checkCodeServlet?time="+new Date().getTime();
            }
        }
    </script>
</head>
<body>
<div style="width: 400px;margin: 50px auto;background: skyblue;border: 1px solid pink;border-radius: 10px">
<form action="${pageContext.request.contextPath}/loginServlet" method="post">
    <div class="form-group">
        <label for="username">用户名:</label>
        <input type="text" class="form-control" id="username" placeholder="请输入用户名" name="username">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">密码</label>
        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="请输入密码" name="password">
    </div>
    <div class="form-group">
        <label for="exampleInputFile">验证码</label>
        <input type="text" id="exampleInputFile" placeholder="请输入验证码" name="verifycode">
              <a href="javascript:refreshCode();">
                  <img src="${pageContext.request.contextPath}/checkCodeServlet" id="vecode">
              </a>
    </div>
    <div class="aa"><button type="submit" class="btn btn-default">登录</button></div>

    <div class="alert alert-warning alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <strong>${login_msg}</strong>
    </div>
</form>
</div>
</body>
</html>
