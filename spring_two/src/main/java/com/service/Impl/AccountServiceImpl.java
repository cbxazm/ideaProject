package com.service.Impl;

import com.Dao.AccountDao;
import com.Dao.Impl.AccountDaoImpl;
//import com.Factory.BeanFactory;
import com.service.AccountService;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao=new AccountDaoImpl();
//    private  AccountDao accountDao= (AccountDao) BeanFactory.getBean("accountDao");
//    private int i=1;（业务层和持久层跟servlet一样变量最好是定义在方法内部去）
        public AccountServiceImpl(){
            System.out.println("对象创建了!");
        }
    public void saveAccount() {
//        int i=1;
                accountDao.saveAccount();
//        System.out.println(i);
//        i++;
    }
}
