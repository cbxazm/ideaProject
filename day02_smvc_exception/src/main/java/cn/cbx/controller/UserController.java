package cn.cbx.controller;

import cn.cbx.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController{
    @RequestMapping("/testException")
    public String testException() throws SysException{
        System.out.println("执行了。。。");
        try {
            //ctrl+alt+t快捷键提示
            int i=1/0;
        } catch (Exception e) {
            //控制台打印信息
            e.printStackTrace();
            //抛出自定义异常信息
            throw new SysException("查询出现了错误");
        }
        return "success";
    }
}
