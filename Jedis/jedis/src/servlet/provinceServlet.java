package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Province;
import service.ProvinceService;
import service.impl.ProvinceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/provinceServlet")
public class provinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          //调用service查询
        ProvinceService service=new ProvinceServiceImpl();
//        List<Province> list = service.findAll();
//        //序列化list为json
//        ObjectMapper mapper=new ObjectMapper();
//        String json = mapper.writeValueAsString(list);
        String allJson = service.findAllJson();
        System.out.println(allJson);
           //响应结果
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(allJson);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
