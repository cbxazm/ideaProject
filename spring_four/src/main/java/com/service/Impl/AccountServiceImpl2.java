package com.service.Impl;

import com.service.AccountService;

import java.util.Date;

//import com.Factory.BeanFactory;

public class AccountServiceImpl2 implements AccountService {

      /*
      这里只是演示数据
       */
      //如果是经常变化的数据，并不适用于注入的方式

    private  String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void saveAccount() {

        System.out.println("service中的saveAccount方法执行了"+name+","+age+","+birthday);
    }

}
