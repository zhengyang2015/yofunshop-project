package com.yofun.controller;

import com.yofun.model.Product;
import com.yofun.service.DisplayProductTypeService;
import com.yofun.service.DisplayProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductDisplayController {

    @Autowired
    private DisplayProductService displayProductService;

    @RequestMapping(value = "/testProduct", method = RequestMethod.GET)
    public String testProduct(@RequestParam String name) {
        return displayProductService.sayHiFromClient(name);
    }

    @RequestMapping(value = "/findAllProduct",method = RequestMethod.GET)
    public String findAllProduct(@RequestParam int productTypeId, Model model) {
        List<Product> products = displayProductService.findAllProduct(productTypeId);
        model.addAttribute("products", products);
        return "products";
    }

}
