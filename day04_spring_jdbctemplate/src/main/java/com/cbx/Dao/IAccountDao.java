package com.cbx.Dao;

import com.cbx.Domain.Account;

public interface IAccountDao {
    /*
    根据id查询账户
     */
     Account findAccountById(Integer accountId);
     /*
         根据名称查询账户
      */
     Account findAccountByName(String accountName);
     /*
     更新账户
      */
     void updateAccount(Account account);
}
