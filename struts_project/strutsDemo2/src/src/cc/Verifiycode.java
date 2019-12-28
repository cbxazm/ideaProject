package cc;

import org.apache.struts2.dispatcher.StrutsResultSupport;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Verifiycode {
    public BufferedImage get(){

        int height=100;
        int width=100;
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.blue);
        graphics.fillRect(0,0,width,height);
        //画边框
        graphics.setColor(Color.black);
        graphics.drawRect(0,0,width-1,height-1);
        //写验证码
        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        for(int i=1;i<=4;i++){
            int index=random.nextInt(str.length());
            //获取字符
            char c=str.charAt(index);
            graphics.drawString(c+"",width/5*i,height/2);
        }
        //画干扰线
        graphics.setColor(Color.GREEN);
        //随机生成坐标点
        for(int i=0;i<10;i++){
            int x1=random.nextInt(width);
            int x2=random.nextInt(width);
            int y1=random.nextInt(height);
            int y2=random.nextInt(height);
            graphics.drawLine(x1,y1,x2,y2);
        }
        return image;
    }








}
