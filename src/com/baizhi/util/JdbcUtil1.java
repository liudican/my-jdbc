package com.baizhi.util;

import com.mysql.jdbc.ResultSet;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JdbcUtil
 * v2.0 by liudc
 */

public class JdbcUtil1 {

    //Properties
    private static Properties map = new Properties();
    // ThreadLocal
    private static final ThreadLocal<Connection> tol = new ThreadLocal<Connection>();

    static {
        InputStream inputStream = JdbcUtil1.class.getResourceAsStream("/com/baizhi/conf/dbcp.properties");
        try {
            map.load(inputStream); // 文件所有数据保存再map里
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() {
        Connection conn = tol.get();
        try {
            Class.forName(map.getProperty("driverClassName"));
            conn = DriverManager.getConnection(map.getProperty("url"), map.getProperty("username"), map.getProperty("password"));
            tol.set(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
                tol.remove();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
