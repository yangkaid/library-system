package com.dao;

import com.common.userBook;

import java.sql.*;

public class maneAddBookDao {
    public static void addbook(userBook book){
        Connection connection = null;
        Statement statement = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/library?serverTimezone=Asia/Shanghai";
            String username1 = "root";
            String password1 = "yangkai";
            connection = DriverManager.getConnection(url,username1,password1);
            statement = connection.createStatement();
            //像数据表中插入数据的SQL语句
            String sql = "insert into user_books( bookname, author, publisher, dingjia,bookid) values (?,?,?,?,?)";
            System.out.println("执行SQL语句");
            //执行预编译的sql语句，第一个参数表示？的位置，第二个参数是具体的值，最后执行SQL语句
            PreparedStatement prestmt = connection.prepareStatement(sql);
            prestmt.setString(1,book.getBookname());
            prestmt.setString(2,book.getAuthor());
            prestmt.setString(3,book.getPublisher());
            prestmt.setFloat(4,book.getDingjia());
            prestmt.setInt(5,book.getBookid());
            prestmt.executeUpdate();
            System.out.println("执行完毕");


        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
