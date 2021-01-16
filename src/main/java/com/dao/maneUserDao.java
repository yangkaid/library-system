package com.dao;

import com.common.User;

import java.sql.*;

public class maneUserDao {
    public static void addUser(User user){
        Connection connection = null;
        Statement statement = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/library?serverTimezone=Asia/Shanghai";
            String username1 = "root";
            String password1 = "yangkai";
            connection = DriverManager.getConnection(url,username1,password1);
            //像数据表中插入数据的SQL语句
            String sql = "insert into user(username, password, name) values (?,?,?)";
            System.out.println("开始执行SQL");
            //执行预编译的sql语句，第一个参数表示？的位置，第二个参数是具体的值，最后执行SQL语句
            PreparedStatement prestmt = connection.prepareStatement(sql);
            prestmt.setString(1,user.getUsername());
            prestmt.setString(2,user.getPassword());
            prestmt.setString(3,user.getName());
            prestmt.executeUpdate();
            System.out.println("SQL执行完毕");


        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
