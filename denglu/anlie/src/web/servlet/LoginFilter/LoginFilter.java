package web.servlet.LoginFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 登录验证的过滤器
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println(req);
        //强制转为HttpServletRequest
        HttpServletRequest request=(HttpServletRequest) req;
        //获取资源的请求路径
        String uri=request.getRequestURI();
        if(uri.contains("/login.jsp")||uri.contains("/loginServlet")||uri.contains("/css/")||uri.contains("/js/")||uri.contains("/fonts/")||uri.contains("/checkCodeServlet")){
                 //说明用户就是想登陆，要放行
            //要注意排除掉css/js/图片/验证码等资源
                chain.doFilter(req,resp);
        }else {
             //不包含，需要验证用户是否登录
            //从获取session中获取user
            Object user = request.getSession().getAttribute("user");
            if(user!=null){
                chain.doFilter(req,resp);
            }else {
                //没有登录，跳转到登录页面
                request.setAttribute("login_msg","您尚未登录");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
