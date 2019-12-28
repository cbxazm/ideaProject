package com.cbx.JdbcTemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * jdbcTemplate最基本的用法
 */
public class JdbcTemplateDem02 {
    public static void main(String[] args) {
       //获取容器
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        //获取对象
        JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
        //执行操作
        template.execute("insert into account (name,money) VALUES ('ggg',3000)");
    }
}
