package servlet;

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

@WebServlet("/checkCodeServlet")
public class checkCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              //服务器通知浏览器不要缓存
        response.setHeader("pragma","no-cache");
        response.setHeader("cache-control","no-cache");
        response.setHeader("expires","0");
        int width=80;
        int height=30;
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //获取画笔
        Graphics graphics=image.getGraphics();
        //设置画笔为灰色
        graphics.setColor(Color.gray);
        //填充图片
        graphics.fillRect(0,0,width,height);
        //产生四个随机的验证码
        String checkCode=getCheckCode();
        //将验证码存入session域中
        request.getSession().setAttribute("check_code",checkCode);
        //设置画笔颜色为黄色
        graphics.setColor(Color.yellow);
        //设置字体大小
        graphics.setFont(new Font("黑体",Font.BOLD,24));
        //在图片上写入验证码
        graphics.drawString(checkCode,15,25);
        ImageIO.write(image,"PNG",response.getOutputStream());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    public String getCheckCode() {
        String base="0123456789ABCDEFGabcdefg";
        int size=base.length();
        Random random=new Random();
        StringBuilder builder=new StringBuilder();
        for(int i=1;i<=4;i++){
             //产生0至size-1的随机值
            int index=random.nextInt(size);
            char c = base.charAt(index);
            builder.append(c);
        }
        return builder.toString();
    }
}
