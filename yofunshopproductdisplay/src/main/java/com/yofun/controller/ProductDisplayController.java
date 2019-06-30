package com.yofun.controller;

import com.yofun.service.ProductDisplayService;
import com.yofun.service.ProductService;
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

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/testProductType", method = RequestMethod.GET)
    @ResponseBody
    public String testProductType(@RequestParam String name) {
        return productDisplayService.sayHiFromClient(name);
    }

    @RequestMapping(value = "/testProduct", method = RequestMethod.GET)
    @ResponseBody
    public String testProduct(@RequestParam String name) {
        return productService.sayHiFromClient(name);
    }

}
