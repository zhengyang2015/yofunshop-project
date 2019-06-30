package com.yofun.controller;

import com.yofun.model.ProductType;
import com.yofun.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableEurekaClient
@RestController
public class ProductTypeIntegrateController {

    @Autowired
    ProductTypeService productTypeService;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String testCloud(@RequestParam String name){
        return "Hi " + name + ", I am from port:";
    }

    @RequestMapping(value = "/findAllProductType",method = RequestMethod.GET)
    public List<ProductType> findAllProductType(){
        return productTypeService.findAllProductType();
    }
}
