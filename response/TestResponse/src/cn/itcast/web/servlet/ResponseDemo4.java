package cn.itcast.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/responseDemo4")
public class ResponseDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //获取字符输出流（流的默认编码为is0-8859）
////        response.setCharacterEncoding("GBK");
//  response.setCharacterEncoding("utf-8");//随便设置什么都行,其实这行也可以不设置，只设置下面的就可以完成上面的功能
//
//        //服务器告诉浏览器本次使用的是什么编码格式,然后建议浏览器使用该编码，只有浏览器读到，就会听你的，
//        response.setHeader("content-type","");
        //简单方法
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        //输出数据
//        writer.write("<h1>hello response</h1>");

        writer.write("你好");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
