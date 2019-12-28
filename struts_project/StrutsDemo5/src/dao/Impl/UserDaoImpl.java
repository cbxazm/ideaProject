package dao.Impl;

import dao.UserDao;
import domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public int addUser(User user) {
             String sql="insert into user values(?,?,?,?,?)";
             try{
                 return template.update(sql, user.getUsername(), user.getPassword(), user.getBirthday(), user.getHobby(), user.getMarried());

             }catch (Exception e){
                 //抛出一个运行时异常
                 throw new RuntimeException(e);

             }
    }
}
