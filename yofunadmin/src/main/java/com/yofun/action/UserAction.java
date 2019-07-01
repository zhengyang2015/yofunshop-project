package com.yofun.action;

import com.yofun.model.User;
import com.yofun.service.UserDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserAction {

    @Autowired
    private UserDisplayService userDisplayService;

    @RequestMapping(value = "/listUser",method = RequestMethod.GET)
    public String listUser(Model model) {
        List<User> users = userDisplayService.listUser();
        model.addAttribute("users", users);
        return "users";
    }
}
