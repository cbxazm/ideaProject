package cc;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestAction2 extends ActionSupport implements ServletRequestAware,ServletResponseAware,ServletContextAware{
    HttpServletRequest request;
    HttpServletResponse response;
    ServletContext application;
    public String test(){
        //获取servlet的api的方式
          /*response
          request
          session
          application(ServletContext)
           */
           /*
           第二种方式，通过实现接口，让struts自动注入进来
            */
        System.out.println(request);
        System.out.println(response);
        System.out.println(application);

        return NONE;//就是不会去找result
    }
    @Override
    public void setServletRequest(HttpServletRequest request) {
              this.request=request;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response=response;
    }

    @Override
    public void setServletContext(ServletContext context) {
        this.application=context;
    }
}
