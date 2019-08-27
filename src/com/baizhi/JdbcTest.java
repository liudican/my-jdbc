package com.baizhi;


import com.baizhi.util.JdbcUtil;
import com.baizhi.util.JdbcUtil1;
import com.baizhi.util.JdbcUtil2;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class JdbcTest {





  /*  public static void main(String[] args) throws Exception {

        // 1.加载MySQL的驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2.获取数据库连接(url,user,password)
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/springboottest", "root", "");
        // 3.创建Statement对象
        Statement stmt = conn.createStatement();
        // 4.使用Statement执行SQL语句
        ResultSet rs = stmt.executeQuery("select * from user");
        // 5.操作结果集
        List<User> users = new ArrayList<User>();
        User user = null;
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int age = rs.getInt(3);
            boolean sex = rs.getBoolean(4);
            Date bir = rs.getDate(5);
            double salary = rs.getDouble(6);
            user = new User(id, name, age, sex, bir, salary);
            users.add(user);
        }
        // 6.回收数据库资源
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }

    }*/


    /*public static void main(String[] args) throws Exception {

        // 1.加载MySQL的驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2.获取数据库连接(url,user,password)
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/springboottest", "root", "");
        // 3.创建Statement对象
        String sql = "insert into user values(?,?,?,?,?,?)"; // 防止SQL注入
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, 0); //自增
        stmt.setString(2,"springboottest");
        stmt.setInt(3,18);
        stmt.setBoolean(4,false); // true:1 false:0
        stmt.setDate(5, new java.sql.Date(new Date().getTime()));
        stmt.setBigDecimal(6,new BigDecimal(300.03));

        // 4.使用Statement执行SQL语句
        stmt.executeUpdate();

        // 5.操作结果集(针对查询)

        // 6.释放资源
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }

    }*/

    /*public static void main(String[] args)  {

        Connection conn = JdbcUtil.conn();
        // 3.创建Statement对象
        String sql = "insert into user values(?,?,?,?,?,?)"; // 防止SQL注入
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 0); //自增
            stmt.setString(2,"springboottest");
            stmt.setInt(3,18);
            stmt.setBoolean(4,false); // true:1 false:0
            stmt.setDate(5, new java.sql.Date(new Date().getTime()));
            stmt.setBigDecimal(6,new BigDecimal(300.03));
            // 4.使用Statement执行SQL语句
            stmt.executeUpdate();
            // 5.操作结果集(针对查询)
            conn.commit(); // 事务提交
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();// 事务回滚
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            // 6.释放资源
            JdbcUtil.close(null,stmt,conn);
        }

    }*/

    @Test
    public void testJ(){
        Connection conn = JdbcUtil.conn();
        System.out.println(conn);
    }

    @Test
    public void testJ1(){
        Connection conn = JdbcUtil1.getConn();
        System.out.println(conn);
    }

    @Test
    public void testJ2(){
        Connection conn = JdbcUtil2.getConn();
        System.out.println(conn);
    }

}
