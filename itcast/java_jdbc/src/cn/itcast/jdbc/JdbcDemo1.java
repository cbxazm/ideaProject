package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * jdbc快速入门
 */
public class JdbcDemo1 {

    public static void main(String[] args) throws Exception {
        //注册驱动
          Class.forName("com.mysql.jdbc.Driver");
          //获取数据库的连接对象
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","123");
            //定义sql语句
        String sql="update account set balance=700 where id=1";
             //获取执行sql的对象Statement
        Statement stmt=con.createStatement();
               //执行sql
        int count=stmt.executeUpdate(sql);
              //处理结果
        System.out.println(count);
        //释放资源
           stmt.close();
           con.close();
    }

}
