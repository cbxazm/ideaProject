package cbxTest;

import com.cbx.Service.IAccountService;
import com.cbx.Service.Impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    public static void main(String[] args) {
//        获取容器
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        //获取对象
        IAccountService accountService=context.getBean("accountService",IAccountService.class);
        //执行方法
        accountService.saveAccount();
    }

}
