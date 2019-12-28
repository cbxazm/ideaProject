package Service.Impl;
/*
管理业务的接口
 */
import Dao.Impl.UserDaoImpl;
import Dao.UserDao;
import Service.UserService;
import domain.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao=new UserDaoImpl();
     public  User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }
}
