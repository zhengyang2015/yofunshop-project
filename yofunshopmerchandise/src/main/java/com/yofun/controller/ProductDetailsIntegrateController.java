package com.yofun.controller;

import com.yofun.model.ProductDetails;
import com.yofun.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@RestController
public class ProductDetailsIntegrateController {

    @Autowired
    ProductDetailsService productDetailsService;

    @RequestMapping(value = "/integrateInsertProductDetails", method = RequestMethod.POST)
    public void insertProductDetails(@RequestBody ProductDetails productDetails) {
        productDetailsService.insertProductDetails(productDetails);
    }
}
