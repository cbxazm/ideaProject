package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*")
public class FilterDemo2 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //放行前对request对象请求消息增强
        System.out.println("filterDemo2...");
        chain.doFilter(req, resp);
        //放行后对response对象的响应消息增强
        System.out.println("filterDemo2..回来啦");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
