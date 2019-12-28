package com.Service.Impl;

import com.Dao.AccountDao;
import com.Service.AccountService;
import com.domain.Account;
import com.utils.TransactionManager;

import java.util.List;
/*
账户的业务层实现类
 */
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;


    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }


    public Account findAccountById(Integer accountId) {
        return null;

    }


    public void saveAccount(Account account) {


    }

    public void updateAccount(Account account) {


    }

    public void deleteAccount(Integer accountId) {

    }

    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer....");
        Account source = accountDao.findAccountByName(sourceName);
        Account target = accountDao.findAccountByName(targetName);
        //2.3转出账户减钱
        source.setMoney(source.getMoney()-money);
        //2.4转入账户加钱
        target.setMoney(target.getMoney()+money);
        //2.5更新转出账户
        accountDao.updateAccount(source);
//        int i=1/0;
        //2.6更新转入账户
        accountDao.updateAccount(target);
    }
}