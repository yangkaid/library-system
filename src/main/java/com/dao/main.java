//package com.dao;
//
//import com.common.User;
//
//import java.sql.SQLException;
//
//public class main {
//    public static void main(String[] args) {
//        User user = new User();
//        UserDaoImpl dao = new UserDaoImpl();
//        try {
//            user = dao.findByUsernameAndPassword("201817416","yangkai");
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        System.out.println(user.getUsername());
//        System.out.println(user.getPassword());
//    }
//}
