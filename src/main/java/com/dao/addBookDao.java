package com.dao;

import com.common.userBook;

import java.sql.*;
import java.util.ArrayList;

public class addBookDao {

    public void setBybookid(int bybookid,String username2) {
        System.out.println(username2);
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;



        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/library?serverTimezone=Asia/Shanghai";
            String username1 = "root";
            String password1 = "yangkai";
            connection = DriverManager.getConnection(url,username1,password1);
            statement = connection.createStatement();
            //使用statement执行SQL语句
            String sql = "update user_books set username = '"+username2+"' where bookid='"+bybookid+"'";
            statement.executeUpdate(sql);


        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }
}
