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

public class UserTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;
    @Before
    public void init() throws IOException {
        in= Resources.getResourceAsStream("SqlMapConfig.xml");
        factory= new SqlSessionFactoryBuilder().build(in);
        session=factory.openSession(true);
        userDao=session.getMapper(IUserDao.class);
    }
    @After
    public void destory() throws IOException {
        in.close();
        session.close();
    }
  @Test
    public void testFindAll(){
      List<User> users = userDao.findAll();
      for(User user:users){
          System.out.println("每个用户的信息");
          System.out.println(user);
          System.out.println(user.getAccounts());
      }
  }
}
