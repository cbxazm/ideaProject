package com.factory;

import com.service.AccountService;
import com.service.Impl.AccountServiceImpl;

public class StaticInstanceFactory {
    public static AccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
