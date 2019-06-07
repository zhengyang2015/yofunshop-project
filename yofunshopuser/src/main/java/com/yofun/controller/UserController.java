package com.yofun.controller;

import com.yofun.model.User;
import com.yofun.service.UserService;
import com.yofun.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    @ResponseBody
    public User getUserInfo() {
        User user = userService.findUserInfo();
        if(user == null) {

        }
        return user;
    }

    @RequestMapping(value = "/toUserRegister", method = RequestMethod.GET)
    public String toUserRegister() {
        return "userregister";
    }

    @RequestMapping(value = "/userRegister", method = RequestMethod.POST)
    public void userRegister(User user) {
        userService.insertUserInfo(user);
        return;
    }

    @RequestMapping(value = "/toUserUpdate", method = RequestMethod.GET)
    public String toUserUpdate(int id, Model model) {
        User user = userService.findByUserId(id);
        model.addAttribute("user", user);
        return "userupdate";
    }

    @RequestMapping(value = "/userUpdate", method = RequestMethod.POST)
    public void userUpdate(User user) {
        userService.updateUser(user);
    }

    @RequestMapping(value = "/findByUserId", method = RequestMethod.GET)
    public String findUserById(int id, Model model) {
        User user = userService.findByUserId(id);
        model.addAttribute("user", user);
        return "userview";
    }

    @RequestMapping(value = "/queryUserByVo", method = RequestMethod.GET)
    public String queryUserByVo(Model model) {
        UserVo userVo = new UserVo();
        List<User> users = userService.queryUserByVo(userVo);
        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping(value = "/deleteUserById", method = RequestMethod.GET)
    public void deleteUserById(int id) {
        userService.deleteUserById(id);
    }
}
