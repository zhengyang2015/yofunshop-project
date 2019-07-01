package com.yofun.service;

import com.yofun.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "yofunshopuser")
public interface UserDisplayService {

    @RequestMapping(value = "/listUser",method = RequestMethod.GET)
    List<User> listUser();
}
