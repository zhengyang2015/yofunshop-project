package com.yofun.controller;

import com.yofun.service.ProductDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductDisplayController {

    @Autowired
    private ProductDisplayService productDisplayService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String testCloud(@RequestParam String name) {
        return productDisplayService.sayHiFromClient(name);
    }
}
