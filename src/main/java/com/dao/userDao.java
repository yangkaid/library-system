package com.dao;

import com.common.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class userDao {
    public static List findallUser(){
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
            String sql = "select * from user";
            resultSet = statement.executeQuery(sql);
            try{
                while (resultSet.next()){
                    User user = new User();
                    System.out.println("打开数据库");
                    user.setName(resultSet.getString("name"));
                    user.setUsername(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));
                    list.add(user);
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
