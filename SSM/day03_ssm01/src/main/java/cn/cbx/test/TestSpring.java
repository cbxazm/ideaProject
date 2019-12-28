package cn.cbx.test;

import cn.cbx.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    @Test
    public void run1(){
           //加载配置文件
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
      AccountService service = (AccountService) context.getBean("accountService");
        //获取对象
        service.findAll();

    }
}
