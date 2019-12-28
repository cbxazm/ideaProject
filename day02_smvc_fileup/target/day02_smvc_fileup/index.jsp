<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>传统方式文件上传</h3>
 <form action="user/fileupload1" enctype="multipart/form-data" method="post">
   选择文件:<input type="file" name="upload"><br>
     <input type="submit" value="上传">
 </form>
<h3>springmvc文件上传方式</h3>
<form action="user/fileupload2" enctype="multipart/form-data" method="post">
    选择文件:<input type="file" name="upload"><br>
    <input type="submit" value="上传">
</form>
</body>
</html>
