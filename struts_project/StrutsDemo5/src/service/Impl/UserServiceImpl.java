package service.Impl;

import dao.Impl.UserDaoImpl;
import dao.UserDao;
import domain.User;
import service.UserService;

public class UserServiceImpl implements UserService {
  UserDao dao=new UserDaoImpl();
    @Override
    public void register(User user) {
           dao.addUser(user);
    }
}
