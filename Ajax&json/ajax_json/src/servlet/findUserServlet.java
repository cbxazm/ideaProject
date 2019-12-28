package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findUserServlet")
public class findUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                        //获取用户名
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
            //调用service层来查询用户名是否存在
        //{"userExists":true,"msg":"此用户名太受欢迎，请换一个"}
        // {"userExists":false,"msg":"用户名可用"}
        Map<String,Object> map= new HashMap<String, Object>();
        if("tom".equals(username)){
            //存在
            map.put("userExists",true);
            map.put("msg","此用户名太受欢迎，请换一个");
        }else {
             map.put("userExists",false);
             map.put("msg","用户名可用");
        }
        //将map转为json,并且传递给客户端
        ObjectMapper mapper =new ObjectMapper();
        mapper.writeValue(response.getWriter(),map);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
