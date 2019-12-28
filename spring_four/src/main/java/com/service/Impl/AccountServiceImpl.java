package com.service.Impl;

import com.Dao.AccountDao;
import com.Dao.Impl.AccountDaoImpl;
//import com.Factory.BeanFactory;
import com.service.AccountService;

import java.util.Date;

public class AccountServiceImpl implements AccountService {

      /*
      这里只是演示数据
       */
      //如果是经常变化的数据，并不适用于注入的方式

    private  String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void saveAccount() {

        System.out.println("service中的saveAccount方法执行了"+name+","+age+","+birthday);
    }

}
