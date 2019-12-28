package com.Ui;

//import com.Factory.BeanFactory;
import com.Dao.AccountDao;
import com.service.AccountService;
import com.service.Impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/*
模拟表现层调用业务层
 */

public class Client {
    public static void main(String[] args) {
        /*
        获取核心容器对象
         */
        //如果使用接口new 实现类对象，不能够调用实现类的方法，所有没有close()
//        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
          ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        /*
        根据id获取bean对象（下面的两种方式都可以,第一种是强转，第二种是拿到字节码转）
         */
         AccountService service=(AccountService)context.getBean("accountService");
//         AccountService service1=context.getBean("accountService",AccountService.class);
//        System.out.println(service==service1);//spring的bean对象默认是单例的
            service.saveAccount();
            context.close();
        }

    }

