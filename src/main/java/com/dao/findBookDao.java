package com.dao;

import com.common.userBook;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class findBookDao {
    //寻找所有用户名为空的书
    public List findBook() {
                Connection connection = null;
                Statement statement = null;
                ResultSet resultSet = null;

        ArrayList list = new ArrayList();
        System.out.println(666);
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/library?serverTimezone=Asia/Shanghai";
            String username1 = "root";
            String password1 = "yangkai";
            connection = DriverManager.getConnection(url,username1,password1);
            statement = connection.createStatement();
            //使用statement执行SQL语句
            String sql = "select * from user_books";
            resultSet = statement.executeQuery(sql);
            try{
                while (resultSet.next()){
                    userBook ubook = new userBook();
                    if(resultSet.getString("username") == null) {
                        ubook.setBookid(resultSet.getByte("bookid"));
                        ubook.setBookname(resultSet.getString("bookname"));

                        ubook.setAuthor(resultSet.getString("author"));
                        ubook.setPublisher(resultSet.getString("publisher"));
                        ubook.setDingjia(resultSet.getFloat("dingjia"));
                        ubook.setStarttime(resultSet.getString("starttime"));
                        ubook.setEndtime(resultSet.getString("endtime"));
                        list.add(ubook);
                    }


                }
            }catch ( SQLException e){
                e.printStackTrace();
            }
        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return list;
//
    }

    //寻找所有图书
    public List findallBook(){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        ArrayList list = new ArrayList();
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/library?serverTimezone=Asia/Shanghai";
            String username1 = "root";
            String password1 = "yangkai";
            connection = DriverManager.getConnection(url,username1,password1);
            statement = connection.createStatement();
            //使用statement执行SQL语句
            String sql = "select * from user_books";
            resultSet = statement.executeQuery(sql);
            try{
                while (resultSet.next()){
                    userBook ubook = new userBook();

                        ubook.setBookid(resultSet.getByte("bookid"));
                        ubook.setBookname(resultSet.getString("bookname"));

                        ubook.setAuthor(resultSet.getString("author"));
                        ubook.setPublisher(resultSet.getString("publisher"));
                        ubook.setDingjia(resultSet.getFloat("dingjia"));
                        ubook.setUsername(resultSet.getString("username"));
                        ubook.setStarttime(resultSet.getString("starttime"));
                        ubook.setEndtime(resultSet.getString("endtime"));
                        list.add(ubook);
                    }



            }catch ( SQLException e){
                e.printStackTrace();
            }
        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return list;

    }


}
