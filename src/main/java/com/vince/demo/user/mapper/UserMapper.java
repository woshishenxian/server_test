package com.vince.demo.user.mapper;

import com.vince.demo.user.entity.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 数据库相关，操作数据库
 */
@Repository
public interface UserMapper extends Mapper<User> {
    int addUserInfo(User user);

    int addUser(User user);

    List<User> queryByUserName(String username);
}
