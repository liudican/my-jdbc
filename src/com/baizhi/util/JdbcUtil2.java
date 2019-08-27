package com.baizhi.util;

import com.mysql.jdbc.ResultSet;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JdbcUtil
 * v3.0 by liudc
 */

public class JdbcUtil2 {

    // dbcp
    private static DataSource ds = null;
    //Properties
    private static Properties map = new Properties();
    // ThreadLocal
    private static final ThreadLocal<Connection> tol = new ThreadLocal<Connection>();

    static {
        InputStream inputStream = JdbcUtil2.class.getResourceAsStream("/com/baizhi/conf/dbcp.properties");
        try {
            map.load(inputStream); // 文件所有数据保存再map里
            ds = BasicDataSourceFactory.createDataSource(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() {
        Connection conn = tol.get();
        try {
           if (conn == null){
               conn = ds.getConnection();
               tol.set(conn);
           }
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
