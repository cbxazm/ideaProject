<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script src="js/jquery.min.js"></script>
    <script>
          $(function () {
          			$("#btn").click(function () {
                        // alert("hello");
                        //发送ajax请求
                        $.ajax({
                            //编写json格式，设置属性和值
                               url:"user/testAjax",
                            contentType:"application/json;charset=UTF-8",
                            data:'{"username":"hehe","password":"123","age":"15"}',
                            dataType:"json",
                            type:"post",
                             success:function (data) {
                                 //data指的是服务器端响应的json数据
                                alert(data.username)
                             }
                        });
                    });
                  });
    </script>
</head>
<body>
<a href="user/testString">testString</a><br>
<a href="user/testVoid">testVoid</a><br>
<a href="user/testModelAndView">testModelAndView</a><br>
<a href="user/testForwardOrRedirect">testForwardOrRedirect</a><br>
<button id="btn">发送ajax请求</button>
</body>
</html>
