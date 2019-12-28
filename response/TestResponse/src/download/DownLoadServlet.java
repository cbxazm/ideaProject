package download;

import utils.DownLoadUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downLoadServlet")
public class DownLoadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           //获取请求参数，文件名称
        String filename = request.getParameter("filename");
//        System.out.println(filename);
               //使用字节输入流加载文件进内存
           //找到真实路径(服务器路径)
        String realPath = this.getServletContext().getRealPath("/img/" + filename + "");
              //使用字节流关联
        FileInputStream inputStream=new FileInputStream(realPath);
                /*
                     设置response的响应头
                        1.设置响应头的类型,content-type
                        2.设置响应头打开方式,content-disposition
                 */
        String mimeType = this.getServletContext().getMimeType(filename);
        response.setHeader("content-type",mimeType);
        //解决中文文件名问题
        String agent = request.getHeader("user-agent");
       filename = DownLoadUtils.getFileName(agent, filename);
        response.setHeader("content-disposition","attachment;filename="+filename+"");
                 //将输入流的数据写出到输出流中
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] buff=new byte[1024*8];
        int len=0;
        while ((len=inputStream.read(buff))!=-1){
                    outputStream.write(buff,0,len);
        }
               inputStream.close();

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
