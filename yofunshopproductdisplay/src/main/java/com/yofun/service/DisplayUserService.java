package com.yofun.service;

import com.yofun.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "yofunshopuser")
@Service
public interface DisplayUserService {

    @RequestMapping(value = "/userIntegrateRegister",method = RequestMethod.POST)
    void userRegister(@RequestBody User user);

    @RequestMapping(value = "/findUserByName",method = RequestMethod.GET)
    User findUserByName(@RequestParam(value = "name") String name);
}
