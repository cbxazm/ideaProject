package com.cbx.dao.Impl;

import com.cbx.dao.IUserDao;
import com.cbx.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao{
   private SqlSessionFactory factory;
   public UserDaoImpl(SqlSessionFactory factory){
       this.factory=factory;
   }
    public List<User> findAll() {
        SqlSession session = factory.openSession();
//        参数就是能获取配置信息的key ，IUserMapper.xml里面的namesapce+方法名
        List<User> users = session.selectList("com.cbx.dao.IUserDao.findAll");
        //释放资源
        session.close();
        return users;
    }

    public void saveUser(User user) {

    }

    public void updateUser(User user) {

    }

    public void deleteUser(Integer userid) {

    }

    public User findById(Integer userid) {
        return null;
    }

    public List<User> findByName(String username) {
        return null;
    }

    public int findTotal() {
        return 0;
    }
}
