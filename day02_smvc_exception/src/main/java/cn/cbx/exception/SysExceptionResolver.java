package cn.cbx.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器
 */
public class SysExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        /**
         * 处理异常
         */
        //获取到异常对象
        SysException exception=null;

        if (e instanceof SysException) {
          exception=(SysException) e;
        } else {
            exception=new SysException("系统正在维护..");
        }
        //创建ModelAndView对象
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("errorMsg",e.getMessage());
        //会调用视图解析器，跳转到error.jsp
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
