package cn.cbx.controller;

import cn.cbx.domain.Account;
import cn.cbx.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/param")
public class ParamController {
    @RequestMapping("/testParam")
      public String testParam(String username,String password){
        System.out.println("执行了。。。");
        System.out.println(username);
        System.out.println(password);
        return "success";
      }
//      将数据封装到javabean的类中
      @RequestMapping("/saveAccount")
  public String saveAccount(Account account){
        System.out.println(account);
        return "success";
      }
//      演示自定义类型转换器
    @RequestMapping("/saveUser")
    public String saveUser(User user){
        System.out.println(user);
        return "success";
    }

    /**
     * 原生的servletapi获取
     * @return
     */
    @RequestMapping("/testServlet")
    public  String testServlet(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request);
        System.out.println(response);
        return "success";
    }
}
