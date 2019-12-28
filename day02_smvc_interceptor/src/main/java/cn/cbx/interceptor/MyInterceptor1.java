package cn.cbx.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 */
public class MyInterceptor1 implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /**
         * 预处理：controller方法执行前就执行了
         * return true:放行，执行下一个拦截器，如果没有，执行controller里面的方法
         * return false:不放行，可以使用request,reponse直接跳转到其他页面去
         */
        System.out.println("myinterceptor....前");
        return true;
    }
    /**
     * 后处理方法，controller中方法处理完执行，success.jsp执行之前
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("myinterceptor....后");
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
        //跳转了之后，success.jsp还是会执行，只是页面跳转到error.jsp中
    }

    /**
     * 在success.jsp页面执行后执行的方法
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("last");
    }
}
