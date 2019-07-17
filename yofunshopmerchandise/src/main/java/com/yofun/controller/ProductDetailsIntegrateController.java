package com.yofun.controller;

import com.yofun.model.ProductDetails;
import com.yofun.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

@EnableEurekaClient
@RestController
public class ProductDetailsIntegrateController {

    @Autowired
    ProductDetailsService productDetailsService;

    @RequestMapping(value = "/integrateInsertProductDetails", method = RequestMethod.POST)
    public void insertProductDetails(@RequestBody ProductDetails productDetails) {
        productDetailsService.insertProductDetails(productDetails);
    }

    @RequestMapping(value = "/integrateFindProductDetailsByProductId", method = RequestMethod.GET)
    public ProductDetails findProductDetailsByProductId(@RequestParam(value = "productId") int productId) {
        return productDetailsService.findByProductId(productId);
    }
}
