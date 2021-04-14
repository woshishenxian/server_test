package com.vince.demo.user.service;

import com.vince.demo.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 定义数据库操作
 */
public interface UserService {
    User getUserInfo();

    void addUserInfo();

    int addUser(String username,int password,String phone);

    List<User> queryByUserName(String username);
}
