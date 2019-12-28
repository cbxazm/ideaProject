package servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        //获取文件真实路径(服务器路径)
        String realPath = context.getRealPath("/b.txt");//web目录下资源的访问
        System.out.println(realPath);
           String c=context.getRealPath("/WEB-INF/c.txt");//WEB-INF目录下的资源访问
        System.out.println(c);
        String realPath1 = context.getRealPath("WEB-INF/classes/a.txt");//src目录下的资源访问（会被放在WEB-INF下的classes下）
        System.out.println(realPath1);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             this.doPost(request,response);
    }
}
