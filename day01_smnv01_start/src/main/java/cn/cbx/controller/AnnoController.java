package cn.cbx.controller;

import cn.cbx.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

/**
 * 常用的注解
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"})//将msg也放置在session域中
public class AnnoController {
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name") String username) {
        System.out.println("执行了");
        System.out.println(username);
        return "success";
    }

    /**
     * PathVariable注解
     *
     * @return
     */
    @RequestMapping("/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name = "sid") String id) {
        System.out.println(id);
        return "success";
    }

    /**
     * 获取请求头的值
     * RequestHeader
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header, @RequestHeader(value = "Cookie") String header1) {
        System.out.println(header);
        System.out.println(header1);
        return "success";
    }

    /**
     * 获取cookie的值
     * CookieValue
     */
    @RequestMapping("/testCookieValue")
    public String testRequestHeader(@CookieValue(value = "JSESSIONID") String cookie) {
        System.out.println(cookie);
        return "success";
    }

    /**
     * ModelAttribute
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user) {
        System.out.println("testModelAttribute执行了");
        System.out.println(user);
        return "success";
    }

    /**
     * 该方法会执行（又返回值得写法）
     */
    @ModelAttribute
    public User showUser(String uname){
        System.out.println("showUser执行了");
        //通过用户查询数据库(模拟)
        User user=new User();
        user.setUname("随便");
        user.setAge(20);
        user.setDate(new Date());
    return  user;

    }

//    /**
//     * 无返回值的写法（利用map存储）
//     */
//    @ModelAttribute
//    public void showUser(String uname, Map<String, User> map) {
//        System.out.println("showUser执行了");
//        //通过用户查询数据库(模拟)
//        User user = new User();
//        user.setUname(uname);
//        user.setAge(20);
//        user.setDate(new Date());
//         map.put("abc",user);
//    }
    /**
     * SessionAttributes
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("执行了....");
        //底层会存储到request域对象
        model.addAttribute("msg","hello");
        return "success";
    }
    /**
     * 获取session域的值
     */
    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap map){
        String msg = (String)map.get("msg");
        System.out.println(msg);
        return "success";
    }
}