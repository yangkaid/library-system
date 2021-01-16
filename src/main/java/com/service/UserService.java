package com.service;

import com.common.User;

public interface UserService {
    /**
     * 用户登录
     *
     * @param user
     * @return
     */
   User login(User user);
}
