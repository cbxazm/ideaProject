package com.cbx;


import com.cbx.Dao.IUserDao;
import com.cbx.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) throws Exception {
        //1.读取配置文件
        InputStream stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(stream);
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //使用sqlsession创建Dao接口的动态代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        //使用代理对象执行方法
        List<User> all = userDao.findAll();
        for (User user:all){
            System.out.println(user);
        }
        //释放资源
        stream.close();
        session.close();
    }
}
