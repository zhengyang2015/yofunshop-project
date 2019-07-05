package com.yofun.controller;

import com.yofun.model.ProductType;
import com.yofun.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/integrateInsertProducttype", method = RequestMethod.POST)
    public void insertProductType(@RequestBody ProductType productType) {
        productTypeService.insertProductType(productType);
    }

    @RequestMapping(value = "/integrateFindProductTypeById", method = RequestMethod.GET)
    public ProductType findProductTypeById(@RequestParam(value = "id") int id) {
        return productTypeService.findProductTypeById(id);
    }
}
