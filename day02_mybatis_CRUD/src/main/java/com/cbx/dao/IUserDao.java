package com.cbx.dao;

import com.cbx.domain.QueryVo;
import com.cbx.domain.User;

import java.util.List;

public interface IUserDao {
    /**
     * 查询所有的用户
     */
    List<User> findAll();
    /**
     * 保存用户
     */
    void saveUser(User user);
    /**
     * 更新用户
     */
    void updateUser(User user);
    /**
     * 根据Id删除用户
     */
           void deleteUser(Integer userid);
    /**
     * 根据id查询用户
     */
    User findById(Integer userid);
    /**
     * 根据username模糊查询
     */
    List<User> findByName(String username);
    /**
     * 查询总用户数
     */
    int findTotal();
    /**
     *根据queryvo中的查询条件来查询
     */
    List<User> findUserByVo(QueryVo vo);
}
