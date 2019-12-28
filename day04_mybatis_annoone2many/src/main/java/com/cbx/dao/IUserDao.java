package com.cbx.dao;

import com.cbx.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * mybatis中针对CRUD有四个注解
 * @Select @Insert @Update @Delete
 */
public interface IUserDao {
    @Select(value = "select * from user")//里面只有一个值的时候value是可以省略的
    @Results( id = "userMap",value = {
            @Result(id=true,column = "id",property = "userId"),
            @Result(column = "username",property = "userName"),
            @Result(column = "sex",property = "userSex"),
            @Result(column = "birthday",property = "userBirthday"),
            @Result(property = "accounts",column = "id",many = @Many(select = "com.cbx.dao.IAccountDao.findAccountById",fetchType = FetchType.LAZY))
    })
    List<User> findAll();
    /**
     * 根据id查询用户
     */
    @Select("select * from user where id=#{id}")
    //只有一个元素value可以省略，数组中只有一个元素,{}可以省略
    @ResultMap(value = {"userMap"})
    User findById(Integer userId);
    /**
     * 通过用户名模糊查询
     */
    @Select("select * from user where username like #{username}")
    //@Select("select * from user where username like "%${value}%")后面就可以直接传值了，固定写法
    @ResultMap(value = {"userMap"})
    List<User> findUserByName(String username);
}
