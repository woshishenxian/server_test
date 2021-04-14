package com.vince.demo.user.service.impl;

import com.vince.demo.user.entity.User;
import com.vince.demo.user.mapper.UserMapper;
import com.vince.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 实现接口操作，承接接口与数据库的连接
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserInfo() {
        User user = new User();
        user.setUsername("刘奇");
        user.setPassword(12344);
        return user;
    }

    @Override
    public void addUserInfo() {
        String username = "jack";
        int password = 123;
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userMapper.addUserInfo(user);
    }

    @Override
    public int addUser(String username, int password, String phone) {
        User user = new User(username, password, phone);
        return userMapper.addUser(user);
    }

    @Override
    public List<User> queryByUserName(String username) {
        return userMapper.queryByUserName(username);
    }
}
