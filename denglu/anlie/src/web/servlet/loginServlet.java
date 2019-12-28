package web.servlet;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request);
             //因为是post请求，设置编码格式
        request.setCharacterEncoding("utf-8");
        //获取数据（用户输入的验证码）
        String verifycode = request.getParameter("verifycode");
        //验证码校验
        HttpSession session = request.getSession();
       String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
       //确保一次性验证码
        session.removeAttribute("CHECKCODE_SERVER");
        if(!checkcode_server.equalsIgnoreCase(verifycode)){
                        //验证码不正确
            //提示信息，跳转登陆页面
            request.setAttribute("login_msg","验证码错误!");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
              //如果验证码没有问题
        Map<String, String[]> parameterMap = request.getParameterMap();
        //封装user对象
        User user=new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用service查询
        UserService service=new UserServiceImpl();
        User loginUser = service.login(user);
        //判断是否登陆成功
        if(loginUser!=null){
             //登陆成功
            //将用户存入session
            session.setAttribute("user",loginUser);
//            //跳转页面
            response.sendRedirect(request.getContextPath()+"/index.jsp");

        }else {
            //提示信息，跳转登陆页面
            request.setAttribute("login_msg","用户名或者错误!");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
