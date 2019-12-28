package com.cbx.dao;

import com.cbx.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * mybatis中针对CRUD有四个注解
 * @Select @Insert @Update @Delete
 */
public interface IUserDao {
    @Select(value = "select * from user")//里面只有一个值的时候value是可以省略的
    List<User> findAll();
    /**
     * 保存用户
     */
    @Insert("insert into user(username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday})")
     void  saveUser(User user);
    /**
     * 更新用户
     */
    @Update("update user set username=#{username},sex=#{sex},address=#{address},birthday=#{birthday} where id=#{id}")
    void updateUser(User user);
    /**
     * 删除用户
     */
    @Delete("delete from user where id=#{id}")
    void deleteUser(Integer userid);
    /**
     * 根据id查询用户
     */
    @Select("select * from user where id=#{id}")
    User findById(Integer userId);
    /**
     * 通过用户名模糊查询
     */
    @Select("select * from user where username like #{username}")
    //@Select("select * from user where username like "%${value}%")后面就可以直接传值了，固定写法
    List<User> findUserByName(String username);
    /**
     * 查询总用户数量
     */
    @Select("select count(*) from user")
    int findTotal();
}
