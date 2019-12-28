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
    public void testSave(){
        User user=new User();
        user.setUsername("mybatis annotation");
        user.setAddress("南京市栖霞区");
        userDao.saveUser(user);
    }
    @Test
    public void testUpdate(){
        User user=new User();
        user.setUsername("mybatis update");
        user.setAddress("南京市栖霞区");
        user.setId(41);
        user.setBirthday(new Date());
        user.setSex("男");
        userDao.updateUser(user);
    }
    @Test
    public void deleteUser(){
         userDao.deleteUser(51);
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
    @Test
    public void findTotal(){
        int total = userDao.findTotal();
        System.out.println(total);
    }
}
