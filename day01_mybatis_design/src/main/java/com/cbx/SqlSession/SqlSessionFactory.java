package com.cbx.SqlSession;

public interface SqlSessionFactory {
    /**
     * 用于打开一个新的SqlSession对象
     */
    SqlSession openSession();
}
