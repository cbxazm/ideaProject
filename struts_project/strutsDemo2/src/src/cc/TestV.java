package cc;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class TestV {
    @Test
    public void test1() throws IOException {
        Verifiycode verifiycode=new Verifiycode();
        BufferedImage image = verifiycode.get();
        HttpServletResponse response = ServletActionContext.getResponse();
              ImageIO.write(image,"PNGs",response.getOutputStream());
    }
}
