package com.itheima.test;

import com.itheima.dao.IRoleDao;
import com.itheima.dao.IUserDao;
import com.itheima.domain.Role;
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
public class RoleTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IRoleDao roleDao;
    @Before
    public void init() throws Exception{
        in=Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
         sqlSession = factory.openSession(true);
         roleDao = sqlSession.getMapper(IRoleDao.class);
    }
@After
public void destory() throws Exception{
        sqlSession.close();
        in.close();
}
@Test
    public  void testFindAll(){
    List<Role> roles = roleDao.findAll();
    for (Role role:roles){
        System.out.println("每个角色的信息");
        System.out.println(role);
        System.out.println(role.getUsers());
    }
}


}
