package com.week05.tm10;

import java.sql.*;

public class HikariCurdDemo {

    public static void main(String[] args) throws Exception {
        Connection conn = HikariDBUtil.getConnection();

        //curd 添加
        add(conn);
        //curd 修改
        modify(conn);
        //curd 查询
        query(conn);
        //curd 删除
        delete(conn);

        query(conn);

        if (conn != null) {
            conn.close();
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

    private static void modify(Connection conn) {
        PreparedStatement psmt =null;
        try {
            String sql = "update t_demo set userName=?,gender=?,age=?,address=?,updateTime=current_date() where id=?";
            //预编译sql语句
            psmt = conn.prepareStatement(sql);
            //先对应SQL语句，给SQL语句传递参数
            psmt.setString(1, "小咖");
            psmt.setString(2, "女");
            psmt.setInt(3, 22);
            psmt.setString(4, "苏州");
            psmt.setInt(5, 2);

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

    private static void delete(Connection conn) {
        PreparedStatement psmt =null;
        try {
            String sql = "delete from t_demo where userName=?";
            //预编译sql语句
            psmt = conn.prepareStatement(sql);
            //先对应SQL语句，给SQL语句传递参数
            psmt.setString(1, "小兴");

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

}


//    CREATE TABLE `t_demo` (
//        `id` int(11) NOT NULL,
//        `userName` varchar(255) NOT NULL,
//        `gender` int(11) DEFAULT NULL,
//        `age` int(11) DEFAULT NULL,
//        `address` varchar(255) DEFAULT NULL,
//        `createTime` datetime DEFAULT NULL,
//        `updateTime` datetime DEFAULT NULL,
//        PRIMARY KEY (`id`)
//        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;