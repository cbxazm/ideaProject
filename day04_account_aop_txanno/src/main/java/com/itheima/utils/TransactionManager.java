package com.itheima.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 和事务管理相关的工具类，它包含了，开启事务，提交事务，回滚事务和释放连接
 */
@Component("txManager")
@Aspect
public class TransactionManager {
  @Autowired
    private ConnectionUtils connectionUtils;
  /*
  切点
   */
    @Pointcut("execution(* com.itheima.service.impl.*.*(..))")
    private void pt1(){

    }
    /**
     * 开启事务
     */
//    @Before("pt1()")
    public  void beginTransaction(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
//    @AfterReturning("pt1()")
    public  void commit(){
        try {
            connectionUtils.getThreadConnection().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
//    @AfterThrowing("pt1()")
    public  void rollback(){
        try {
            connectionUtils.getThreadConnection().rollback();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * 释放连接
     */
//    @After("pt1()")
    public  void release(){
        try {
            connectionUtils.getThreadConnection().close();//还回连接池中
            connectionUtils.removeConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //使用上面的单个配置可能会在提交事务的时候出问题
    /**
     * 推荐使用环绕通知
     */
    public Object arroundAdvice(ProceedingJoinPoint joinPoint){
               Object rtValue=null;
               try{
                   //获取参数
                   Object[] args=joinPoint.getArgs();
                   //开启事务
                   this.beginTransaction();
                   //执行方法
                   rtValue=joinPoint.proceed(args);
                   //提交事务
                   this.commit();
                   return rtValue;
               }catch (Throwable e){
                     //回滚事务
                   this.rollback();
                   throw new RuntimeException(e);
               }finally {
                   //释放
                   this.release();
               }
    }
}
