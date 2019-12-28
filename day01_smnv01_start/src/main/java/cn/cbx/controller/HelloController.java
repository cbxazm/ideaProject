package cn.cbx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
    @RequestMapping(path = "/hello",method = RequestMethod.GET,params = "username")
    public String sayHello(){
        System.out.println("hello ");
        return "success";
    }
}
