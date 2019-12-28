package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*")
public class FilterDemo3 implements Filter {
    public void destroy() {
        //在服务器正常关闭的情况下，执行该方法，执行一次，用于释放资源
        System.out.println("destory....");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("doFilter...");//执行多次
        chain.doFilter(req, resp);
    }
/*
服务器启动后就会创建Filter对象，然后调用init方法
 */
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init....");//执行一次，用于加载资源
    }

}
