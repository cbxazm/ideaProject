package servlet;

import Service.Impl.UserServiceImpl;
import Service.UserService;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;

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
                 request.setCharacterEncoding("utf-8");
                 //获取数据
                  String verifycode=request.getParameter("verifycode");
                  //验证码检验
        HttpSession session = request.getSession();
        String check_code=(String) session.getAttribute("check_code");
             //要确保验证码是一次性的
        session.removeAttribute("check_code");
        if(!check_code.equalsIgnoreCase(verifycode)){
            //验证码不正确
            request.setAttribute("login_msg","验证码输入有误!");
               //跳转登录页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;//下面的无需执行
        }
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
            //调用service来查询
        UserService service=new UserServiceImpl();
        User loginUser = service.login(user);
        if(loginUser!=null){
             //登陆成功，并且将用户存入session域
              session.setAttribute("user",loginUser);
              response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else {
            request.setAttribute("login_msg","用户名或者密码错误!");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
