package com.cbx.utils;

import com.cbx.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 用于创建数据源的工具类
 */
public class DataSourceUtil {
    public static Connection getConnection(Configuration cfg) {
        /**
         * 用于获取连接
         */
        try {
            Class.forName(cfg.getDriver());
            return DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        } catch (Exception e) {
          throw  new RuntimeException(e);
        }
    }
}
