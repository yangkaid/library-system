package com.dao;

import com.common.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

public class UserServiceImple implements UserService {

     UserDaoImpl userDao=new UserDaoImpl();
    /**
     * 用户登录
     *
    * @param user
     * @return
     */
    @Override
    @Autowired
  public User login(User user) {
        User user2 = new User();
        try {
            user2 = userDao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("service:"+user2.getUsername());
        System.out.println("service:"+user2.getPassword());
        return user2;
    }


}
