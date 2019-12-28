package com.Service.Impl;

import com.Dao.AccountDao;
import com.Service.AccountService;
import com.domain.Account;
import com.utils.TransactionManager;

import java.util.List;

/*
账户的业务层实现类
 */
public class AccountServiceImplCopy implements AccountService {
    private AccountDao accountDao;
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        try {
            //开启事务
            transactionManager.beginTranscation();
            //执行操作
            List<Account> accounts = accountDao.findAllAccount();
            //提交事务
            transactionManager.commitTranscation();
            //返回结果
            return accounts;
        } catch (Exception e) {
            //回滚操作
            transactionManager.rollBackTranscation();
            throw  new RuntimeException(e);
        } finally {
            //释放连接
            transactionManager.release();
        }

    }


    public Account findAccountById(Integer accountId) {
        try {
            //开启事务
            transactionManager.beginTranscation();
            //执行操作
            Account accountById = accountDao.findAccountById(accountId);
            //提交事务
            transactionManager.commitTranscation();
            //返回结果
            return accountById;
        } catch (Exception e) {
            //回滚操作
            transactionManager.rollBackTranscation();
            throw new RuntimeException(e);
        } finally {
            //释放连接
            transactionManager.release();
        }

    }



    public void saveAccount(Account account) {
        try {
            //开启事务
            transactionManager.beginTranscation();
            //执行操作
            accountDao.saveAccount(account);
            //提交事务
            transactionManager.commitTranscation();
            //返回结果
        } catch (Exception e) {
            //回滚操作
            transactionManager.rollBackTranscation();
        } finally {
            //释放连接
            transactionManager.release();
        }

    }

    public void updateAccount(Account account) {
        try {
            //开启事务
            transactionManager.beginTranscation();
            //执行操作
            accountDao.updateAccount(account);
            //提交事务
            transactionManager.commitTranscation();
            //返回结果
//            return accounts;
        } catch (Exception e) {
            //回滚操作
            transactionManager.rollBackTranscation();
        } finally {
            //释放连接
            transactionManager.release();
        }

    }

    public void deleteAccount(Integer accountId) {

    }

    public void transfer(String sourceName, String targetName, Float money) {
        try {
            //开启事务
            transactionManager.beginTranscation();
            //执行操作
            //2.1根据名称查询转出账户
            Account source = accountDao.findAccountByName(sourceName);
            //2.2根据名称查询转入账户
            Account target = accountDao.findAccountByName(targetName);
            //2.3转出账户减钱
            source.setMoney(source.getMoney() - money);
            //2.4转入账户加钱
            target.setMoney(target.getMoney() + money);
            //2.5更新转出账户
            accountDao.updateAccount(source);
            int i = 1 / 0;
            //更新转入账户
            accountDao.updateAccount(target);
            //提交事务
            transactionManager.commitTranscation();
//            //返回结果
//            return accounts;
        } catch (Exception e) {
            //回滚操作
            transactionManager.rollBackTranscation();
            e.printStackTrace();
        } finally {
            //释放连接
            transactionManager.release();
        }

    }
}
