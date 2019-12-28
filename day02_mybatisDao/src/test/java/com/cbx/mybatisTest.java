package com.cbx;

import com.cbx.dao.IUserDao;
import com.cbx.dao.Impl.UserDaoImpl;
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

public class mybatisTest {
    //抽取重复代码
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;
    @Before//用于在测试方法之前执行
    public void init() throws IOException {
        //读取配置文件,生成字节输入流
       in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获取sqlsessionFactory
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
//        //获取sqlSession对象
//         sqlSession=factory.openSession();
//        //获取dao的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
//        userDao=new UserDaoImpl(factory);
    }
    @After//用于在测试方法后
    public void destory() throws Exception{
        in.close();
    }
    @Test
    /**
     * 测试查询所有用户
     */
    public void test1() throws IOException {
        List<User> all = userDao.findAll();
        for (User user:all){
            System.out.println(user);
        }

    }


}
