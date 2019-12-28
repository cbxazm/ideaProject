package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/*
JDBC工具类 使用Durid连接池
 */
public class JDBCUtils {

    private static DataSource ds;
    static {

        try {
            //加载配置文件
            Properties pro=new Properties();
            InputStream stream = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(stream);
            //初始化连接池对象
            ds= DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //获取connection对象
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();

    } //获取连接池对象
    public static  DataSource getDataSource(){
        return ds;
    }


}
