package cn.itcast.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                  request.setCharacterEncoding("utf-8");
      String username=request.getParameter("username");
      String password=request.getParameter("password");
      String checkCode=request.getParameter("checkCode");
        HttpSession session = request.getSession();
        String check_code =(String) session.getAttribute("check_code");
        //删除验证码(消除后退后还能输入刚才的验证码的bug)
        session.removeAttribute("check_code");
               if(check_code!=null&&check_code.equalsIgnoreCase(checkCode)){
                    if("zhangsan".equalsIgnoreCase(username)&&"123".equals(password)){
                        session.setAttribute("user",username);
                              response.sendRedirect(request.getContextPath()+"/success.jsp");
                    }else {

                        request.setAttribute("login_error","用户名和密码错误");
                        //转发到登录页面
                        request.getRequestDispatcher("/login.jsp").forward(request,response);
                    }


               }else{
                        //验证码不一致，存储错误信息到request域中
                   request.setAttribute("checkcode_error","验证码错误");
                   //转发到登录页面
                   request.getRequestDispatcher("/login.jsp").forward(request,response);
    }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
