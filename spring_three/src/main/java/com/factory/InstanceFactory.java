package com.factory;

import com.service.AccountService;
import com.service.Impl.AccountServiceImpl;

/*
模拟一个工厂类（该类可能存在jar包中，无法修改源码来提供默认的构造函数）
 */
public class InstanceFactory {
     public AccountService getAccountService(){
         return new AccountServiceImpl();
     }
}
