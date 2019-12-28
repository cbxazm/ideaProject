package com.cbx.JdbcTemplate;

import com.cbx.Dao.IAccountDao;
import com.cbx.Domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * jdbcTemplate最基本的用法
 */
public class JdbcTemplateDem04 {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao dao=context.getBean("accountDao",IAccountDao.class);
        Account accountById = dao.findAccountById(1);
        accountById.setMoney(77777f);
        dao.updateAccount(accountById);
        System.out.println(accountById);
    }
}
