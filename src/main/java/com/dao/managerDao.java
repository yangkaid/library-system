package com.dao;
import com.common.manager;
import java.sql.*;

public class managerDao {
    public static manager login(String username){
        System.out.println(username);
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        manager manager = new manager();
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/library?serverTimezone=Asia/Shanghai";
            String username1 = "root";
            String password1 = "yangkai";
            connection = DriverManager.getConnection(url,username1,password1);
            statement = connection.createStatement();
            //使用statement执行SQL语句
            String sql = "select * from maneger";
            resultSet = statement.executeQuery(sql);
            try{
                while (resultSet.next()){

                    if (username.equals(resultSet.getString("username"))){

                        manager.setUsername(resultSet.getString("username"));
                        manager.setPassword(resultSet.getString("password"));
                    }
                }
            }catch ( SQLException e){
                e.printStackTrace();
            }
        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return manager;

    }
}
