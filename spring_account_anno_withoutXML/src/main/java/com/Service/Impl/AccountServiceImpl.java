package com.Service.Impl;


import com.Dao.AccountDao;
import com.Service.AccountService;
import com.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/*
账户的业务层实现类
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
 @Autowired  //因为只有唯一的一个的对象，可以使用这个
  private AccountDao accountDao;

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }


    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
            accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
              accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
             accountDao.deleteAccount(accountId);
    }
}
