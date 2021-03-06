package com.yofun.controller;

import com.yofun.model.ProductType;
import com.yofun.service.DisplayProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductTypeDisplayController {

    @Autowired
    DisplayProductTypeService displayProductTypeService;

    @RequestMapping(value = "/testProductType", method = RequestMethod.GET)
    public String testProductType(@RequestParam String name) {
        return displayProductTypeService.sayHiFromClient(name);
    }

    @RequestMapping(value = "/findAllProductType",method = RequestMethod.GET)
    public String findAllProductType(Model model) {
        List<ProductType> productTypes = displayProductTypeService.findAllProductType();
        model.addAttribute("productTypes", productTypes);
        return "producttypes";
    }
}
