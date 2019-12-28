package com.cbx.dao;

import com.cbx.domain.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询所有的账户并且获取每个账户所属的用户信息
     */
    @Select("select * from account")
    @Results(id = "accountMap",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "money",property = "money"),
            @Result(column = "uid",property = "user",one=@One(select = "com.cbx.dao.IUserDao.findById"))
    })
    List<Account> findAll();

/**
 * 根据用户id查询账户信息
 */
@ResultMap("accountMap")
@Select("select * from account where uid=#{userId}")
    List<Account> findAccountById(Integer userid);
}
