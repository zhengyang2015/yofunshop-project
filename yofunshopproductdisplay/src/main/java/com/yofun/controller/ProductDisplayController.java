package com.yofun.controller;

import com.yofun.model.Product;
import com.yofun.service.DisplayProductTypeService;
import com.yofun.service.DisplayProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductDisplayController {

    @Autowired
    private DisplayProductTypeService displayProductTypeService;

    @Autowired
    private DisplayProductService displayProductService;

    @RequestMapping(value = "/testProductType", method = RequestMethod.GET)
    @ResponseBody
    public String testProductType(@RequestParam String name) {
        return displayProductTypeService.sayHiFromClient(name);
    }

    @RequestMapping(value = "/testProduct", method = RequestMethod.GET)
    @ResponseBody
    public String testProduct(@RequestParam String name) {
        return displayProductService.sayHiFromClient(name);
    }

    @RequestMapping(value = "/listProduct",method = RequestMethod.GET)
    public String lisProduct(@RequestParam int productTypeId, Model model) {
        List<Product> products = displayProductService.lisProduct(productTypeId);
        model.addAttribute("products", products);
        return "products";
    }

}
