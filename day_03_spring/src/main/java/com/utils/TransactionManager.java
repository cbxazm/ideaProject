package com.utils;

import java.sql.SQLException;

/*
和事务管理相关的工具类，开始事务，提价事务，回滚事务和释放连接
 */
public class TransactionManager {
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public void beginTranscation(){
           //开启事务
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void commitTranscation(){
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void rollBackTranscation(){
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void release(){
        try {
            connectionUtils.getThreadConnection().close();
            //这里的close()也是将连接还回连接池
            connectionUtils.removeConnection();//把线程和连接解绑
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
