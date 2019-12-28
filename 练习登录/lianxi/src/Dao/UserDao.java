package Dao;

import domain.User;

import java.util.List;

public interface UserDao {
    User findUserByUsernameAndPassword(String username, String password);

    List<User> findAll();
}
