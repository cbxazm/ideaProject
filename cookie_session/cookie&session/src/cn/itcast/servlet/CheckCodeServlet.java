package cn.itcast.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet( "/checkCode")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             int width=100;
             int height=50;
              //创建一个对象，在内存中图片(验证码图片对象)
        BufferedImage image= new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
          //美化图片
        Graphics g = image.getGraphics();//获取画笔对象
        g.setColor(Color.pink);//设置画笔颜色
        g.fillRect(0,0,width,height);//填充背景
        //画边框
          g.setColor(Color.blue);
          g.drawRect(0,0,width-1,height-1);//边框有一像素的
        //写验证码
        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        //生成随机角标
        Random ran=new Random();
        StringBuilder sb=new StringBuilder();
        for (int i = 1; i <=4 ; i++) {
            int index = ran.nextInt(str.length());
            //获取字符
            char c = str.charAt(index);//随机字符
            sb.append(c);
            g.drawString(c+"",width/5*i,height/2);
        }
        String check_code = sb.toString();
        //存入session域中
        request.getSession().setAttribute("check_code",check_code);

        //画干扰线
         g.setColor(Color.green);
        //随机生成坐标点
        for (int i = 0; i <10 ; i++) {
            int x1=ran.nextInt(width);
            int x2=ran.nextInt(width);
            int y1=ran.nextInt(height);
            int y2=ran.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }
        //将图片输出到页面展示
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           this.doPost(request,response);
    }
}
