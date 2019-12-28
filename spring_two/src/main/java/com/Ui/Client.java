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
/*
根据spring的ioc核心容器，并根据id获取对象
 */
/*
ApplicationContext的三个常用实现类
   ApplicationContext的三个常用实现类：
     *      ClassPathXmlApplicationContext：它可以加载类路径下的配置文件，要求配置文件必须在类路径下。不在的话，加载不了。(更常用)
     *      FileSystemXmlApplicationContext：它可以加载磁盘任意路径下的配置文件(必须有访问权限）
     *      AnnotationConfigApplicationContext：它是用于读取注解创建容器的，是明天的内容。
     *
 */
public class Client {
    public static void main(String[] args) {
//        AccountService service=new AccountServiceImpl();
        //使用BeanFactory
//        for(int i=1;i<=5;i++){
//            AccountService service= (AccountService) BeanFactory.getBean("accountService");
//            System.out.println(service);
        /*
        获取核心容器对象
         */
//        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext context=new FileSystemXmlApplicationContext("F:\\ideaproject\\spring_two\\src\\main\\resources\\bean.xml");
        /*
        根据id获取bean对象（下面的两种方式都可以,第一种是强转，第二种是拿到字节码转）
         */
//         AccountService service=(AccountService)context.getBean("serviceAccount");
//        AccountDao dao=context.getBean("serviceDao",AccountDao.class);
//        System.out.println(service);
//        System.out.println(dao);
////            service.saveAccount();
//        }
        Resource resource=new ClassPathResource("bean.xml");
        BeanFactory factory=new XmlBeanFactory(resource);
        AccountService service=factory.getBean("serviceAccount",AccountService.class);
        System.out.println(service);
    }
}
