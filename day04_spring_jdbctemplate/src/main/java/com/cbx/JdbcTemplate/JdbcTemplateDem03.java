package com.cbx.JdbcTemplate;

import com.cbx.Domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class JdbcTemplateDem03 {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        //更新操作
//        jdbcTemplate.update("insert into account (name,money) VALUES (?,?)","eeee",9999);
            //更新操作
//        jdbcTemplate.update("UPDATE  account set name=? ,money=? WHERE NAME ='eeee'","zhangsan",8888);
        //删除操作
//        jdbcTemplate.update("delete from account where name=?","zhangsan");
        //查询所有
//        List<Account> query = jdbcTemplate.query("select * from account where money>?", new AccountRowMapper(), 1000);
        //用这种方式更简单
//        List<Account> query = jdbcTemplate.query("select * from account where money>?", new BeanPropertyRowMapper<Account>(Account.class), 1000);
//        for(Account account:query){
//            System.out.println(account);
//        }
        //查询一个
//        List<Account> query = jdbcTemplate.query("select * from account where id=?", new BeanPropertyRowMapper<Account>(Account.class), 9);
//        System.out.println(query.size()==0?"没有内容":query.get(0));
                     //查询返回一行一列(使用聚合函数，但是不加 group by子句)
        //该方法根据第二个参数.class来返回数据类型
        Integer integer = jdbcTemplate.queryForObject("select count(*) from account where money>?", Integer.class, 1000);
        System.out.println(integer);

    }
}
class AccountRowMapper implements RowMapper<Account>{
    /**
     * 把结果集的数据封装到Account中，然后由spring把每个Account加到集合
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
          Account account=new Account();
          account.setId(resultSet.getString("id"));
          account.setName(resultSet.getString("name"));
          account.setMoney(resultSet.getFloat("money"));
        return account;
    }
}
