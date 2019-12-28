package com.factory;

import com.Service.AccountService;
import com.domain.Account;
import com.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class BeanFactory {
    /*
    用于创建service的代理对象的工厂
     */
    private AccountService accountService;
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
    public final void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
/*
获取service的代理对象
 */
    public AccountService getAccountService(){
        return (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
            //添加事务的支持
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue=null;
                        try {
                            //开启事务
                            transactionManager.beginTranscation();
                            //执行操作
                            rtValue = method.invoke(accountService, args);
                            //提交事务
                            transactionManager.commitTranscation();
                            //返回结果
                            return rtValue;
                        } catch (Exception e) {
                            //回滚操作
                            transactionManager.rollBackTranscation();
                            throw new RuntimeException(e);
                        } finally {
                            //释放连接
                            transactionManager.release();
                        }
                    }
                }
        );
    }
}
