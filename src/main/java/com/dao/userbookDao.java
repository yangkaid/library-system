package com.dao;

import com.common.User;
import com.common.userBook;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class userbookDao {



    public List findByUsername(String username) throws SQLException {

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
            String sql = "select * from user_books where username = '"+username+"'";
            resultSet = statement.executeQuery(sql);
            try{
                while (resultSet.next()){
                    userBook ubook = new userBook();
                    System.out.println("打开数据库");
//                 user.setUid(resultSet.getInt("uid"));
//                 user.setUsername(resultSet.getString("username"));
//                 user.setPassword(resultSet.getString("password"));
//                 user.setName(resultSet.getString("name"));
                    ubook.setUsername(resultSet.getString("username"));
                    ubook.setBookname(resultSet.getString("bookname"));
                    ubook.setBookid(resultSet.getByte("bookid"));
                    ubook.setAuthor(resultSet.getString("author"));
                    ubook.setPublisher(resultSet.getString("publisher"));
                    ubook.setDingjia(resultSet.getFloat("dingjia"));
                    ubook.setStarttime(resultSet.getString("starttime"));
                    ubook.setEndtime(resultSet.getString("endtime"));
                    list.add(ubook);


                }
            }catch ( SQLException e){
                e.printStackTrace();
            }
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return list;


    }


}

