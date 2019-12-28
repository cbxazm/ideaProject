package cc;

import com.opensymphony.xwork2.ActionInvocation;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsResultSupport;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

/*
验证码的结果类型
 */
public class CAPTCHA extends StrutsResultSupport{
    @Override
    protected void doExecute(String finalLocation, ActionInvocation invocation) throws Exception {
        //生成验证码
          Verifiycode verifiycode=new Verifiycode();
        BufferedImage image = verifiycode.get();
        //获取response
        HttpServletResponse response = ServletActionContext.getResponse();
        //响应给客户端
        ImageIO.write(image,"PNG",response.getOutputStream());
    }
}
