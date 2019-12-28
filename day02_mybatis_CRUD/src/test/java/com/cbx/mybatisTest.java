package com.cbx;

import com.cbx.dao.IUserDao;
import com.cbx.domain.QueryVo;
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
        //获取sqlSession对象
         sqlSession=factory.openSession();
        //获取dao的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }
    @After//用于在测试方法后
    public void destory() throws Exception{
        //提交事务
        sqlSession.commit();
        sqlSession.close();
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

    /**
     * 测试保存用户，以及保存后返回的id值
     */
    @Test
    public void testSave()  {
        User user=new User();
        user.setUsername("张三");
        user.setAddress("南京市雨花台区");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("保存操作之前"+user);
           userDao.saveUser(user);
        System.out.println("保存操作之后"+user);
       //必须添加提交事务
        sqlSession.commit();
    }
    @Test
    public void testUpdate(){
        User user=new User();
        user.setId(41);
        user.setBirthday(new Date());
        user.setAddress("南京市");
        user.setSex("男");
        user.setUsername("lee");
        userDao.updateUser(user);
        //必须添加提交事务
        sqlSession.commit();
    }
    @Test
    public void testDelete(){
       userDao.deleteUser(42);
//       sqlSession.commit();
    }
    @Test
    public void testFind(){
        User user = userDao.findById(48);
        System.out.println(user);
    }
    /**
     * 测试模糊查询
     */
    @Test
    public void testFindByName(){
//        User user = userDao.findById(48);
//        System.out.println(user);
        List<User> users = userDao.findByName("%王%");
        System.out.println(users);
    }
    @Test
    public void testTotal(){
        int total = userDao.findTotal();
        System.out.println(total);
    }
    /**
     * 测试使用queryvo作为查询条件
     */
    @Test
    public void testFindByVo(){
        QueryVo vo=new QueryVo();
        User user=new User();
        user.setUsername("%王%");
        vo.setUser(user);
        List<User> users = userDao.findUserByVo(vo);
        for(User user1:users){
            System.out.println(user1);
        }

    }
}
