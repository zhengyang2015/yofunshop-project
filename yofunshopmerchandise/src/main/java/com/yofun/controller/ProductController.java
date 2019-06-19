package com.yofun.controller;

import com.yofun.model.Product;
import com.yofun.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/insertProduct", method = RequestMethod.POST)
    public void insertProduct(Product product) {
        product.setCreatedAt(LocalDateTime.now());
        product.setSellNumber(0);
        productService.insertProduct(product);
    }

    @RequestMapping(value = "/toProductRegister", method = RequestMethod.GET)
    public String toProductRegister(Product product) {
        return "productregister";
    }
}
