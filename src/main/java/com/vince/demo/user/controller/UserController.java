package com.vince.demo.user.controller;

import com.vince.demo.user.entity.Response;
import com.vince.demo.user.entity.User;
import com.vince.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 接口相关，定义接口形式
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/getUserItem", method = RequestMethod.GET)
    public String getUserItem() {
        User user = userService.getUserInfo();
        return user.toString();
    }

    @RequestMapping(value = "/addUserInfo", method = RequestMethod.GET)
    public Response addUserInfo() {
        userService.addUserInfo();
        Response res = new Response();
        res.setMsg("添加成功");
        res.setCode(1);
        return res;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
    public Response register(@RequestBody Map<String, String> person) {
        String username = person.get("username");
        int password = Integer.parseInt(person.get("password"));
        String phone = person.get("phone");
        //1.判断用户名、密码、手机号是否为空
        if (username != null && password != 0 && phone != null) {
            List<User> users = userService.queryByUserName(username);
            //2.判断是否有重复用户名
            if (users != null && users.size() > 0) {
                return new Response(true, "注册失败，用户名重复,请更换", -1);
            } else {
                int count = userService.addUser(username, password, phone);
                if (count > 0) {
                    //3.没有重复用户名，注册成功
                    return new Response(true, "注册成功", 1);
                } else {
                    return new Response(true, "注册失败", -1);
                }
            }
        } else {
            return new Response(true, "注册失败，请检查用户名、密码、手机号是否为空", -1);
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    public Response login(@RequestBody Map<String, String> person) {
        String username = person.get("username");
        int password = Integer.parseInt(person.get("password"));
        //1. 判断用户名、密码是否为空
        if (username != null && password != 0) {
            List<User> users = userService.queryByUserName(username);
            //2. 判断用户名是否存在
            if (users != null && users.size() > 0) {
                User user = users.get(0);
                //3. 判断密码是否正确
                if (password == user.getPassword()) {
                    //4. 密码正确，登陆成功
                    return new Response(true, "登陆成功", 1);
                } else {
                    return new Response(false, "登陆失败，密码错误", -1);
                }
            } else {
                return new Response(true, "登陆失败，用户名不存在", -1);
            }
        } else {
            return new Response(true, "登陆失败，请检查用户名、密码是否为空", -1);
        }
    }
}
