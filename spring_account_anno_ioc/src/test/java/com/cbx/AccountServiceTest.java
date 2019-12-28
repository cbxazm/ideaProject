package com.cbx;

import Service.AccountService;
import Service.Impl.AccountServiceImpl;
import domain.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

//使用junit单元测试，测试配置
public class AccountServiceTest {
     @Test
    public void testFindAll(){
               //获取容器
         ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
         //得到业务层的对象
         AccountService service=context.getBean("accountService",AccountService.class);
         //执行方法
         List<Account> allAccount = service.findAllAccount();
         for(Account account:allAccount){
             System.out.println(account);
         }
//         System.out.println(allAccount);
     }
    @Test
    public void testFindOne(){
        //获取容器
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        //得到业务层的对象
        AccountService service=context.getBean("accountService",AccountService.class);
        Account account = service.findAccountById(1);
        System.out.println(account);
    }
    @Test
    public void testSave(){
        //获取容器
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        //得到业务层的对象
        AccountService service=context.getBean("accountService",AccountService.class);
        Account account=new Account();
        account.setName("test");
        account.setMoney(1234f);
        service.saveAccount(account);

    }
    @Test
    public void testUpdate(){
        //获取容器
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        //得到业务层的对象
        AccountService service=context.getBean("accountService",AccountService.class);
        Account account = service.findAccountById(3);
        account.setMoney(1111f);
        service.updateAccount(account);
    }
    @Test
    public void testDelete(){
        //获取容器
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        //得到业务层的对象
        AccountService service=context.getBean("accountService",AccountService.class);
        service.deleteAccount(2);
    }
}
