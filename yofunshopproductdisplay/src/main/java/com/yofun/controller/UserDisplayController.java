package com.yofun.controller;

import com.yofun.model.User;
import com.yofun.service.DisplayUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserDisplayController {

    @Autowired
    private DisplayUserService displayUserService;

    @RequestMapping(value = "/toUserRegister", method = RequestMethod.GET)
    public String toUserRegister() {
        return "userregister";
    }

    @RequestMapping(value = "/userRegister", method = RequestMethod.POST)
    public void userRegister(User user) {
        displayUserService.userRegister(user);
    }

    @RequestMapping(value = "/toUserLogin", method = RequestMethod.GET)
    public String toUserLogin() {
        return "login";
    }

}
