package com.cbx;


import com.cbx.dao.IUserDao;
import com.cbx.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisAnnoTest {
    /**
     * 测试基于注解的mybatis的使用
     * @param args
     */
    public static void main(String[] args) throws IOException {
        InputStream stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = builder.build(stream);
        SqlSession sqlSession = sessionFactory.openSession(true);
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> users = userDao.findAll();
        for(User user:users){
            System.out.println(user);
        }
        stream.close();
        sqlSession.close();
    }
}
