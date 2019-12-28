package com.cbx.JdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * jdbcTemplate最基本的用法
 */
public class JdbcTemplateDem01 {
    public static void main(String[] args) {
        //准备数据源：spring的内置数据源
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring");
        dataSource.setUsername("root");
        dataSource.setPassword("123");
          //创建JdbcTemplate对象
        JdbcTemplate template=new JdbcTemplate();
        //给template设置数据源
        template.setDataSource(dataSource);
        //执行操作
        template.execute("INSERT into account(name,money) VALUES ('hhh',10000)");
    }
}
