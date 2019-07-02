package com.yofun.controller;

import com.yofun.model.User;
import com.yofun.service.UserService;
import com.yofun.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@EnableEurekaClient
@RestController
public class UserIntegrateController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/listUser", method = RequestMethod.GET)
    public List<User> listUser() {
        UserVo userVo = new UserVo();
        List<User> users = userService.queryUserByVo(userVo);
        return users;
    }

    @RequestMapping(value = "/userIntegrateRegister", method = RequestMethod.POST)
    public void userRegister(@RequestBody User user) {
        userService.insertUserInfo(user);
    }
}
