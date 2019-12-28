package Action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import domain.User;
import org.apache.commons.lang3.StringUtils;
import service.Impl.UserServiceImpl;
import service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User> {
      private User user=new User();
    @Override
    public User getModel() {
        return user;
    }
    public String register(){
        System.out.println("register方法.....");
        System.out.println(user);
//        //调用业务方法
//        UserService service=new UserServiceImpl();
////        service.register(user);
      /*
      struts自带的表单验证方法
      第一种:重写validate方法，如果数据不对，可以往FieldError添加字段错误信息
       */
        return NONE;
    }
               //在action里面验证表单
//    @Override
//    public void validate() {
//        //一旦有错误信息，就不会去执行register方法
//        //判断用户名是否为空
////        if(username==null&&"".equals(username)) 写下面的这句就相当于上面的两句话
//          if(StringUtils.isEmpty(user.getUsername())){
//                 addFieldError("username","用户名不能为空");
//          }
//          //判断密码是否为空
//        if(StringUtils.isEmpty(user.getPassword())){
//               addFieldError("password","密码不能为空");
//        }
//
//    }

}
