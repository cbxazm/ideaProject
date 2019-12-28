package com.cbx.Dao.Impl;

import com.cbx.Dao.IAccountDao;
import com.cbx.Domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AccountDaoImpl2  extends JdbcDaoSupport implements IAccountDao {


    public Account findAccountById(Integer accountId) {
        //因为下面的语句有返回值，所有不能直接return
        List<Account> query =super.getJdbcTemplate().query("select * from account where id=?", new BeanPropertyRowMapper<Account>(Account.class), accountId);
        return query.isEmpty()?null:query.get(0);
    }

    public Account findAccountByName(String accountName) {
        List<Account> accounts = super.getJdbcTemplate().query("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class), accountName);
        if(accounts.isEmpty()){
              return null;
          }
          if (accounts.size()>1){
             throw new RuntimeException("结果集不唯一");
          }
        return accounts.get(0);
    }

    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("UPDATE account set name=?,money=? where id=? ",account.getName(),account.getMoney(),account.getId());
    }
}
