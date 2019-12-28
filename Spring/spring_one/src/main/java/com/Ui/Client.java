package com.Ui;

import com.Factory.BeanFactory;
import com.service.AccountService;
import com.service.Impl.AccountServiceImpl;

/*
模拟表现层调用业务层
 */
public class Client {
    public static void main(String[] args) {
//        AccountService service=new AccountServiceImpl();
        //使用BeanFactory
        for(int i=1;i<=5;i++){
            AccountService service= (AccountService) BeanFactory.getBean("accountService");
            System.out.println(service);
            service.saveAccount();
        }

    }
}
