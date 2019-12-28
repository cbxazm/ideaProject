package Dao.Impl;

import Dao.UserDao;
import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
          try{
              String sql="select * from user where username=? and password=?";
              User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
              return user;
          }catch (Exception e){
              e.printStackTrace();
              return null;
          }

    }

    @Override
    public List<User> findAll() {
        String sql="select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;

    }
}
