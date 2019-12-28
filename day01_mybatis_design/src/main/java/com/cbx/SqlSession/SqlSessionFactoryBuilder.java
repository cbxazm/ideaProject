package com.cbx.SqlSession;

import com.cbx.SqlSession.defaults.DeaultSqlSessionFactory;
import com.cbx.cfg.Configuration;
import com.cbx.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 用于创建一个SqlSeesionFactory对象
 */
public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(InputStream config){
        Configuration cfg= XMLConfigBuilder.loadConfiguration(config);
       return new DeaultSqlSessionFactory(cfg);
    }
}
