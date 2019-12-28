package web.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
     public String login(){
         //读取资源包数据
         System.out.println(getText("login.username"));
         System.out.println(getText("login.password"));
         System.out.println(getText("login.submit"));
         return NONE;
     }
}
