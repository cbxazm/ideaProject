package com.cbx.Dao;

import com.cbx.domain.User;

import java.util.List;

public interface IUserDao {
    //查询所有操作
    List<User> findAll();

}
