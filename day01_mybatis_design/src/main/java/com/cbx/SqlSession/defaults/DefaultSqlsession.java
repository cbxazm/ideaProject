package com.cbx.SqlSession.defaults;

import com.cbx.SqlSession.SqlSession;
import com.cbx.cfg.Configuration;
import com.cbx.proxy.MapperProxy;
import com.cbx.utils.DataSourceUtil;

import javax.sql.DataSource;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

public class DefaultSqlsession implements SqlSession {

    private Configuration cfg;
    private Connection conn;
    public DefaultSqlsession(Configuration cfg){
        this.cfg=cfg;
        conn= DataSourceUtil.getConnection(cfg);
    }
    /**
     * 用于创建代理对象
     * @param daoInterfaceClass
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass},new MapperProxy(cfg.getMappers(),conn));
    }
    /**
     * 用于释放资源
     */
    public void close() {
       if(conn!=null){
           try {
               conn.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
    }
}
