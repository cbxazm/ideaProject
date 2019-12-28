<%@ page import="cn.itcast.domain.User" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取数据</title>
</head>
<body>
<%
         User user=new User();
    user.setName("张三");
    user.setAge(23);
    user.setBirthday(new Date());
    request.setAttribute("u",user);
    List list=new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add(user);
    request.setAttribute("list",list);
    Map map=new HashMap();
    map.put("sname","李四");
    map.put("gender","男");
    map.put("user",user);
    request.setAttribute("map",map);
%>
          <h3>el获取对象中的值</h3>
      ${requestScope.u}
<h3>获取属性值</h3>
${requestScope.u.name}
${requestScope.u.age}
${u.birthday}
${u.birthday.year}
${u.birthday.month}
<hr>
${u.bitStr}
<hr>
${list}<br>
${list[0]}
${list[1]}
${list[2].name}
${list[10]}

<hr>
${map.sname}
${map.gender}
<%--跟上面的作用一样--%>
${map["sname"]}
${map.user.name}
</body>
</html>
