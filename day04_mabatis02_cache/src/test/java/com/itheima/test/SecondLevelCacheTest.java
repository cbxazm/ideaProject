package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 *
 * 测试mybatis的crud操作
 */
public class SecondLevelCacheTest {
    private InputStream in;
    private SqlSessionFactory factory;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
    }
    @After
    public void destory() throws Exception {
        in.close();
    }

    /**
     * 二级缓存前还需要配置三个地方
     * 结果对象虽然是从缓存中拿，但是却不是同一个对象，这是因为sqlsessionfactory中存放的是数据，来了一个请求就把数据封装进去
     */
  @Test
    public void testSecondLevel(){
         SqlSession sqlSession1=factory.openSession(true);
      IUserDao userDao1 = sqlSession1.getMapper(IUserDao.class);
      User user1 = userDao1.findById(41);
      System.out.println(user1);
      sqlSession1.close();//一级缓存消失
      SqlSession sqlSession2=factory.openSession(true);
      IUserDao userDao2 = sqlSession2.getMapper(IUserDao.class);
      User user2 = userDao2.findById(41);
      System.out.println(user2);
      sqlSession1.close();//一级缓存消失
      System.out.println(user1==user2);
  }
}

