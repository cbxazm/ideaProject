package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookieTime")
public class cookieTime extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             response.setContentType("text/html;charset=utf-8");
        //获取所有的cookie
        Cookie[] cookies = request.getCookies();
        boolean flag=false;//没有cookie为lastTime
        if(cookies!=null&&cookies.length>0){
                for(Cookie cookie:cookies){
                    //获取cookie的名称
                    String name = cookie.getName();
                    //判断名称是否是lastTime
                    if("lastTime".equals(name)){
                        flag=true;
                                  //不是第一次访问
                        //设置cookie的value值，获取当前的时间字符串，重新设置cookie的值，重新发送cookie
                        Date date=new Date();
                        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy年MM月dd日 HH：mm:ss");
                        String format = dateFormat.format(date);
                        System.out.println("编码前:"+format);
                        //URL编码
                        format=URLEncoder.encode(format,"utf-8");
                        System.out.println("编码后"+format);
                        cookie.setValue(format);
                        //设置cookie的存活时间
                        cookie.setMaxAge(60*60);//一个月
                        response.addCookie(cookie);
                        //响应数据
                        String value = cookie.getValue();
                        System.out.println("解码前"+value);
                           //url解码
                        value = URLDecoder.decode(value, "utf-8");
                        System.out.println("解码后"+value);
                        response.getWriter().write("<h1>欢迎回来，您上次访问时间为:"+value+"</h1>");
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
            response.getWriter().write("<h1>您好，欢迎首次登陆</h1>");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
