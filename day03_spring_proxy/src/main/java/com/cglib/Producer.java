package com.cglib;

import com.proxy.Iproducer;

/*

一个生产者
 */
public class Producer {
    //如果这个类不实现该接口，基于接口的动态代理就不能用
     public void saleProduct(float money){
         System.out.println("销售产品"+money+"钱");
     }

     public void afterService(float money){
         System.out.println("提供售后服务"+money+"钱");
     }

}
