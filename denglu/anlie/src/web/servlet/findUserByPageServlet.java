package web.servlet;

import domain.PageBean;
import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserByPageServlet")
public class findUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         request.setCharacterEncoding("utf-8");
        //获取参数
        String currentPage = request.getParameter("currentPage");
        String rows=request.getParameter("rows");
        if(currentPage==null||"".equals(currentPage)||Integer.parseInt(currentPage)<=0){
                               currentPage="1";
        }
        String totalPage=request.getParameter("totalPage");
         if(totalPage!=null){
             if(Integer.parseInt(currentPage)>=Integer.parseInt(totalPage)){
                 currentPage=totalPage;
             }
         }
        if(rows==null||"".equals(rows)){
             rows="3";
        }
        //获取条件查询的参数
        Map<String, String[]> condition = request.getParameterMap();


        //调用service来查询
        UserService service =new UserServiceImpl();
        PageBean<User> pageBean=service.findUserByPage(currentPage,rows,condition);

        System.out.println(pageBean);
        //将pageBean存入request
        request.setAttribute("pageBean",pageBean);
        request.setAttribute("condition",condition);//将查询条件存入request
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
