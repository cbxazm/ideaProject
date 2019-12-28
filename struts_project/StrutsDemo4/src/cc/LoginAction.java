package cc;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import domain.User;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
//方式二  使用set方法
public class LoginAction extends ActionSupport implements ModelDriven<User>{
    private  String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
//set方法会在login()方法之前运行完
    public String login(){
           //获取请求参数
        //第一种方式:通过request对象
//        HttpServletRequest request = ServletActionContext.getRequest();
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        System.out.println(username);
//        System.out.println(password);
        //第二种方式，通过属性的set注入
        //第四种方式，使用模型驱动
        System.out.println(user);
        return NONE;
    }
  private User user=new User();//一定要在这里创建一个对象
    @Override
    public User getModel() {
        return user;
    }
}
