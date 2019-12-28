package com.cbx;

import com.cbx.dao.IAccountDao;
import com.cbx.dao.IUserDao;
import com.cbx.domain.Account;
import com.cbx.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IAccountDao accountDao;
    @Before
    public void init() throws IOException {
        in= Resources.getResourceAsStream("SqlMapConfig.xml");
        factory= new SqlSessionFactoryBuilder().build(in);
        session=factory.openSession(true);
        accountDao=session.getMapper(IAccountDao.class);
    }
    @After
    public void destory() throws IOException {
        in.close();
        session.close();
    }
  @Test
    public void testFindAll(){
      List<Account> accounts = accountDao.findAll();
      for(Account account:accounts){
          System.out.println("每个账户的信息");
          System.out.println(account);
          System.out.println(account.getUser());
      }
  }
}
