package cn.cbx.controller;

import cn.cbx.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 返回值类型是string
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model){
        //从数据库模拟User对象
        User user=new User();
        user.setUsername("张三");
        user.setPassword("123");
        user.setAge(12);
        //model对象相当于存在request域中
         model.addAttribute("user",user);
         return "success";
    }
    /**
     * 返回值类型是void
     * 请求转发是一次请求，不用编写项目的名称
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("执行了");
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
//        //不想让下面代码执行
        //不能直接访问WEB-INF下面的页面
        response.sendRedirect(request.getContextPath()+"/index.jsp");
        return;
    }
    /**
     * 返回值ModelAndView
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        User user=new User();
        user.setUsername("张三");
        user.setPassword("123");
        user.setAge(12);
        //ModelAndView对象也是相当于存在request域中
        modelAndView.addObject("user",user);
        //跳转到那个页面
        modelAndView.setViewName("success");
        return modelAndView;
    }
    /**
     * 使用关键字转发或重定向
     */
    @RequestMapping("testForwardOrRedirect")
    public String testForwardOrRedirect(){
//        return "forward:/WEB-INF/pages/success.jsp";
        //这里重定向不加项目名也可以，底层已经实现
       return "redirect:/index.jsp";
    }

    /**
     * 处理ajax请求
     */
     @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
         System.out.println("执行了...");
         System.out.println(user);
  //做响应模拟数据库
         user.setUsername("haha");
         user.setAge(40);
         //做响应
         return user;
               }
}
