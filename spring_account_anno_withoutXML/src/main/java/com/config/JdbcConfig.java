package com.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

/*
和spring连接数据库相关的配置信息
 */
//@Configuration
//如果不加这个注解，就要下面这样
// ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfiguration.class, JdbcConfig.class);
//  Bean
// *      作用：用于把当前方法的返回值作为bean对象存入spring的ioc容器中
// *      属性:
// *          name:用于指定bean的id。当不写时，默认值是当前方法的名称
// *      细节：
// *          当我们使用注解配置方法时，如果方法有参数，spring框架会去容器中查找有没有可用的bean对象。
// *          查找的方式和Autowired注解的作用是一样的
// PropertySource
//         *      作用：用于指定properties文件的位置
//         *      属性：
//         *          value：指定文件的名称和路径。
//         *                  关键字：classpath，表示类路径下
//         *                  /
//         *                  */
public class JdbcConfig {
    @Value("${jdbc.driver}")
         private String driver;
    @Value("${jdbc.url}")
         private String url;
    @Value("${jdbc.username}")
         private String username;
    @Value("${jdbc.password}")
         private String password;
    //创建一个QueryRunner对象
    @Bean(name = "runner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }
    //创建数据源对象
    @Bean(name = "dataSource")
    public DataSource createDatasource(){
        try{
            ComboPooledDataSource source=new ComboPooledDataSource();
            source.setDriverClass(driver);
            source.setJdbcUrl(url);
            source.setUser(username);
            source.setPassword(password);
            return  source;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
