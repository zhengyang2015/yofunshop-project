package com.yofun.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "yofunshopmerchandise")
@Service
public interface ProductService {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String sayHiFromClient(@RequestParam(value = "name") String name);
}
