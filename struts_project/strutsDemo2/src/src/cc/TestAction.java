package cc;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestAction extends ActionSupport {
      public String test(){
      //获取servlet的api的方式
          /*
          response
          request
          session
          application(ServletContext)
           */
           /*
           第一种方式，通过ServletActionContext
            */
          HttpServletResponse response = ServletActionContext.getResponse();
          HttpServletRequest request = ServletActionContext.getRequest();
          HttpSession session = request.getSession();
          ServletContext servletContext = ServletActionContext.getServletContext();
          System.out.println(response);
          System.out.println(request);
          System.out.println(session);
          System.out.println(servletContext);
//          org.apache.catalina.connector.ResponseFacade@77c34d38
//          org.apache.struts2.dispatcher.StrutsRequestWrapper@2dfa6ed  属于struts，其余三个属于tomcat
//          org.apache.catalina.session.StandardSessionFacade@63a5d704
//          org.apache.catalina.core.ApplicationContextFacade@561d402f
          return NONE;//就是不会去找result
      }

}
