package com.cbx.Dao.Impl;

import com.cbx.Dao.IUserDao;
import com.cbx.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;

public class IUserDaoImpl implements IUserDao{
    private SqlSessionFactory factory;
    public IUserDaoImpl(SqlSessionFactory factory){
        this.factory=factory;
    }
    public List<User> findAll() {
          //使用工厂创建sqlsession对象
        SqlSession sqlSession = factory.openSession();
        //使用session执行查询所有方法
        List<User> users = sqlSession.selectList("com.cbx.Dao.IUserDao.findAll");
        sqlSession.close();
        return users;
    }
}
