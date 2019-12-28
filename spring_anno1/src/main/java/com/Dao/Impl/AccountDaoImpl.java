package com.Dao.Impl;

import com.Dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class AccountDaoImpl implements AccountDao {


    public void saveAccount() {
        System.out.println("保存了账户");
    }

}
