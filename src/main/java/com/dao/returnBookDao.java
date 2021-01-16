package com.dao;

import com.common.userBook;

import java.sql.*;
import java.util.ArrayList;

public class returnBookDao {
    public  static void returnBook(int bookid){
        Connection connection = null;
        Statement statement = null;
        try {
            System.out.println("开始链接数据库");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/library?serverTimezone=Asia/Shanghai";
            String username1 = "root";
            String password1 = "yangkai";
            connection = DriverManager.getConnection(url,username1,password1);
            statement = connection.createStatement();
            //使用statement执行SQL语句
            String sql = "update user_books set username=null where bookid='"+bookid+"'";
            statement.executeUpdate(sql);
            System.out.println("语句执行完毕");

        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
