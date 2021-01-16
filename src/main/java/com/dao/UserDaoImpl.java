package com.dao;

import com.common.User;

import java.sql.*;
import  com.mysql.jdbc.Driver;


 class UserDaoImpl {

//根据用户名和密码查询用户

     public User findByUsernameAndPassword(String username, String password) throws SQLException {

         Connection connection = null;
         Statement statement = null;
         ResultSet resultSet = null;
         User user = new User();
         try {

             Class.forName("com.mysql.cj.jdbc.Driver");
             String url = "jdbc:mysql://localhost:3306/library?serverTimezone=Asia/Shanghai";
             String username1 = "root";
             String password1 = "yangkai";
             connection = DriverManager.getConnection(url,username1,password1);
             statement = connection.createStatement();
             //使用statement执行SQL语句
             String sql = "select * from User";
             resultSet = statement.executeQuery(sql);
            try{
                while (resultSet.next()){
                    System.out.println("打开数据库");
//                 user.setUid(resultSet.getInt("uid"));
//                 user.setUsername(resultSet.getString("username"));
//                 user.setPassword(resultSet.getString("password"));
//                 user.setName(resultSet.getString("name"));
                    if (username.equals(resultSet.getString("username"))){
                        user.setUsername(resultSet.getString("username"));
                        user.setPassword(resultSet.getString("password"));
                        System.out.println(user.getUsername());
                        System.out.println(user.getPassword());
                    }
                }
            }catch ( SQLException e){
                e.printStackTrace();
            }
         }catch (ClassNotFoundException e) {
             e.printStackTrace();
         }

         return user;


     }
 }



