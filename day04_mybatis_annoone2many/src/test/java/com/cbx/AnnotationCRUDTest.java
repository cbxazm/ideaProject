package com.cbx;

import com.cbx.dao.IUserDao;
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
import java.util.Date;
import java.util.List;

public class AnnotationCRUDTest {
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
public void findAll(){
    List<User> users = userDao.findAll();
    for(User user:users){
        System.out.println(user);
    }

}
    @Test
    public void findOne(){
        User user = userDao.findById(50);
        System.out.println(user);
    }
    @Test
    public void findUserByName(){
        List<User> user = userDao.findUserByName("%mybatis%");
        System.out.println(user);
    }

}
