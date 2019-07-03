package com.yofun.controller;

import com.yofun.model.User;
import com.yofun.service.DisplayUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    @RequestMapping(value = "/userLogin", method = RequestMethod.GET)
    public String userLogin(String name, String password, HttpServletRequest request) {
        User user = displayUserService.findUserByName(name);
        if(user == null) {
            System.out.println("No User find with name : " + name);
        } else {
            if(password != null && password.equals(user.getPasswordencrypt())) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
            } else {
                System.out.println("Invalid password");
            }
        }

        return "list";
    }

}
