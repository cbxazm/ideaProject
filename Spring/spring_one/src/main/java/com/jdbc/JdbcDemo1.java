package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
演示程序的耦合
 */
/*
解耦:降低程序之间的耦合性
 实际开发应该做到：编译期不依赖，运行时才依赖
 解决思路:
 第一步：使用反射来创建对象，避免使用new关键字
 第二步:通过读取配置文件来获取创建对象全限定类名
 */
public class JdbcDemo1 {
    public static void main(String[] args)  throws  Exception{
                 //注册驱动
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //class.forName("com.mysql.jdbc.Driver");
              //获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "123");
        //获取操作数据库的预处理对象
        PreparedStatement statement = connection.prepareStatement("select * from account");
         //执行sql,得到结果集
        ResultSet set = statement.executeQuery();
        while (set.next()){
            System.out.println(set.getString("name"));
        }
        //释放资源
        connection.close();
        statement.close();
        set.close();
    }
}
