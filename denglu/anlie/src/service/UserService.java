package service;

import domain.PageBean;
import domain.User;

import java.util.List;
import java.util.Map;

/*
用户管理的业务接口
 */
public interface UserService {
    public List<User> findAll();


    User login(User user);
          //保存对象user
    void addUser(User user);
           //根据id删除user
    void deleteUser(String id);
          //根据id查询user
    User findUserById(String id);
         //修改用户信息
    void updateUser(User user);
        //删除选中的用户
    void delSelectedUser(String[] uids);
           //分页条件查询
    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
