package com.cbx.SqlSession.defaults;

import com.cbx.SqlSession.SqlSession;
import com.cbx.SqlSession.SqlSessionFactory;
import com.cbx.cfg.Configuration;

import java.io.InputStream;

/**
 * sqlsessionfactory接口的实现类
 */
public class DeaultSqlSessionFactory  implements SqlSessionFactory{
    private Configuration cfg;
    public DeaultSqlSessionFactory(Configuration cfg){
        this.cfg=cfg;
    }
    /**
     * 用于创建一个新的操作数据库的=对象
     * @return
     */
    public SqlSession openSession() {
        return new DefaultSqlsession(cfg);
    }
}
