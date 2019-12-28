<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //获取所有的cookie
    Cookie[] cookies = request.getCookies();
    boolean flag=false;//没有cookie为lastTime
    if(cookies!=null&&cookies.length>0) {
        for (Cookie cookie : cookies) {
            //获取cookie的名称
            String name = cookie.getName();
            //判断名称是否是lastTime
            if ("lastTime".equals(name)) {
                flag = true;
                //不是第一次访问
                //设置cookie的value值，获取当前的时间字符串，重新设置cookie的值，重新发送cookie
                Date date = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH：mm:ss");
                String format = dateFormat.format(date);
                System.out.println("编码前:" + format);
                //URL编码
                format = URLEncoder.encode(format, "utf-8");
                System.out.println("编码后" + format);
                cookie.setValue(format);
                //设置cookie的存活时间
                cookie.setMaxAge(60 * 60);//一个月
                response.addCookie(cookie);
                //响应数据
                String value = cookie.getValue();
                System.out.println("解码前" + value);
                //url解码
                value = URLDecoder.decode(value, "utf-8");
                System.out.println("解码后" + value);
                %>
                    <h1>欢迎回来，您上次访问的时间是:<%=value%></h1>
<%
                break;
            }
        }
    }
    if(cookies==null||cookies.length==0||flag==false){
        //啥都没有，第一次访问
        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy年MM月dd日 HH：mm:ss");
        String format = dateFormat.format(date);
        System.out.println("编码前"+format);
        //url编码
        format=URLEncoder.encode(format,"utf-8");
        System.out.println("编码后"+format);
        Cookie cookie=new Cookie("lastTime",format);
        //设置cookie的存活时间
        cookie.setMaxAge(60*60);//一个月
        response.addCookie(cookie);
        %>
       <h1>您好，欢迎首次访问</h1>
<%
    }
 %>

</body>
</html>
