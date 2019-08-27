package com.baizhi.util;

import com.mysql.jdbc.ResultSet;

import java.sql.*;

/**
 * JdbcUtil
 * v1.0 by liudc
 */

public class JdbcUtil {

    public static Connection conn() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/springboottest", "root", "");
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
