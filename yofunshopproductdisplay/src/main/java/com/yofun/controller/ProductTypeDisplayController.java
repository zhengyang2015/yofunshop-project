package com.yofun.controller;

import com.yofun.model.ProductType;
import com.yofun.service.DisplayProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductTypeDisplayController {

    @Autowired
    DisplayProductTypeService displayProductTypeService;

    @RequestMapping(value = "/findAllProductType",method = RequestMethod.GET)
    public List<ProductType> findAllProductType() {
        List<ProductType> productTypes = displayProductTypeService.findAllProductType();
        return productTypes;
    }
}
