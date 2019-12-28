package cn.cbx.test;

import cn.cbx.dao.AccountDao;
import cn.cbx.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class TestMybatis {
    @Test
    public void run1() throws Exception {
        //加载mybatis的配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
     //创建一个sqlSessionFactory对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        List<Account> accounts = accountDao.findAll();
        for (Account account:accounts ){
            System.out.println(account);
        }
        sqlSession.close();
        inputStream.close();
    }

    /**
     * 增删改方法自己得手动提交事务
     * @throws Exception
     */
    @Test
    public void run2() throws Exception {
        //加载mybatis的配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建一个sqlSessionFactory对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        Account account=new Account();
        account.setName("张飞");
        account.setMoney(5000.0);
        accountDao.saveAccount(account);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }
}
