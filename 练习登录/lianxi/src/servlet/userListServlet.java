package servlet;

import Service.Impl.UserServiceImpl;
import Service.UserService;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userListServlet")
public class userListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                   //调用userservice来查询
        UserService service =new UserServiceImpl();
        List<User> users = service.findAll();
        request.setAttribute("users",users);
//        System.out.println(users);
        request.getRequestDispatcher("/list.jsp").forward(request,response);

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
