//package com.dao;
//
//import com.common.User;
//
//import java.sql.*;
//
//public class MySQLDemo {
//    public static void main(String[] args)throws SQLException {
//        Connection connection = null;
//        Statement statement = null;
//        ResultSet resultSet = null;
//        User user = new User();
//        try {
//
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            String url = "jdbc:mysql://localhost:3306/library?serverTimezone=Asia/Shanghai";
//            String username = "root";
//            String password = "yangkai";
//            connection = DriverManager.getConnection(url,username,password);
//            statement = connection.createStatement();
//            //使用statement执行SQL语句
//            String sql = "select * from User";
//            resultSet = statement.executeQuery(sql);
//            while (resultSet.next()){
//                System.out.println("打开数据库");
//                user.setUid(resultSet.getInt("uid"));
//                user.setUsername(resultSet.getString("username"));
//                user.setPassword(resultSet.getString("password"));
//                user.setName(resultSet.getString("name"));
//                System.out.println(user.getName());
//
//
//
//            }
//        }catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
