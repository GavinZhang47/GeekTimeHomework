package com.week05.tm10;

import java.sql.*;

public class TransactionDemo {

    public static void main(String[] args) {
        Connection conn = JdbcDBUtil.getConnection();
        try {
            conn.setAutoCommit(false);
            query(conn);
            add(conn);
            int i = 1 / 0; //错误
            query(conn);
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void add(Connection conn) {
        PreparedStatement psmt =null;
        try {
            String sql = "" +
                    "insert into t_demo" +
                    "(userName,gender,age,address,createTime,updateTime) " +
                    "values(?,?,?,?,current_date(),current_date())";//参数用?表示，相当于占位符;用mysql的日期函数current_date()来获取当前日期
            //预编译sql语句
            psmt = conn.prepareStatement(sql);
            //先对应SQL语句，给SQL语句传递参数
            psmt.setString(1, "小兴");
            psmt.setString(2, "男");
            psmt.setInt(3, 21);
            psmt.setString(4, "南京");

            //执行SQL语句
            psmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (psmt != null) {
                    psmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void query(Connection conn) {
        Statement stmt =null;
        try {
            //3.通过数据库的连接操作数据库，实现增删改查
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select id,userName,gender,age,address,createTime,updateTime from t_demo");//选择import java.sql.ResultSet;
            while (rs.next()) {//如果对象中有数据，就会循环打印出来
                System.err.println(rs.getString("id") + "," + rs.getString("userName") + "," + rs.getString("gender") + "," + rs.getString("age") + "," + rs.getString("address") + "," + rs.getInt("createTime") + "," + rs.getInt("updateTime"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
