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
public class UserTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;
    private  SqlSessionFactory factory;
    @Before
    public void init() throws Exception{
        in=Resources.getResourceAsStream("SqlMapConfig.xml");
       factory=new SqlSessionFactoryBuilder().build(in);
         sqlSession = factory.openSession(true);
         userDao = sqlSession.getMapper(IUserDao.class);
    }
@After
public void destory() throws Exception{
        sqlSession.close();
        in.close();
}

    /**
     * 测试一级缓存，sqlSession一关闭就没得缓存了
     * 方式一sqlsession.close()
     * 方式二sqlsession.clearCache();
     */
  @Test
    public void testFirstLevelCache(){
      User user = userDao.findById(41);
      System.out.println(user);
      sqlSession.close();
      //再次获取sqlsession对象
      sqlSession=factory.openSession(true);
      IUserDao userDao = sqlSession.getMapper(IUserDao.class);
      User user1= userDao.findById(41);
      System.out.println(user1);
//      System.out.println(user==user1);//true--第一次是查询，第二次是从缓存中取
      System.out.println(user==user1);//false不再是同一个对象了
  }

    /**
     * 测试缓存的同步
     * 当调用sqlsession的修改，添加，删除，commit(),close()等方法时，就会清空一级缓存
     */
    @Test
    public void testClearCache() {
        User user1 = userDao.findById(41);
        System.out.println(user1);
        //更新用户信息
        user1.setUsername("update user clear cache");
        user1.setAddress("南京市鼓楼区");
        userDao.updateUser(user1);
        //再次查询id为41的用户“
        User user2=userDao.findById(41);
        System.out.println(user2);
        System.out.println(user1==user2);



    }

}
