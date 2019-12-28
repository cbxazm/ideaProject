package cn.cbx.service;

import cn.cbx.domain.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();

    void saveAccount(Account account);
}
