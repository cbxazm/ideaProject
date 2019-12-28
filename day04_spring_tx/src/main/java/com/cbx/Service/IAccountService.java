package com.cbx.Service;

import com.cbx.Domain.Account;

public interface IAccountService {
    Account findAccountById(Integer accountId);
    void transfer(String sourceName,String targetName,Float money);
}
