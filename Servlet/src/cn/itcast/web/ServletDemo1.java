package cn.itcast.web;

import javax.servlet.*;
import java.io.IOException;

/*
servlet快速入门
 */
public class ServletDemo1 implements Servlet{

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
           //初始化方法，在servlet创建时执行，且只执行一次
        System.out.println("init........");
    }

    @Override
    public ServletConfig getServletConfig() {
        //获取servletconfig(配置对象)的方法
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
//         提供服务的方法，每一次servlet被访问都会执行，执行多次
        System.out.println("service...");
    }

    @Override
    public String getServletInfo() {
        //获取一些servlet信息的。。。版本作者，，。。。
        return null;
    }

    @Override
    public void destroy() {
           //销毁方法，在servlet被杀死时执行，执行一次
        System.out.println("destory");
    }
}
