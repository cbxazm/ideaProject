package test;

import com.config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
测试queryRunner是否是单例
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class QueryRunnerTest {
    @Autowired
    private QueryRunner runner=null;
    @Test
    public  void testQueryRunner(){
//        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        runner=context.getBean("runner",QueryRunner.class);
//         runner2=context.getBean("runner",QueryRunner.class);
        System.out.println(runner);
        System.out.println(new QueryRunner());
//        System.out.println(runner==runner2);//结果为true，是单例的，所有需要在前面把它改为多例的
    }
}
