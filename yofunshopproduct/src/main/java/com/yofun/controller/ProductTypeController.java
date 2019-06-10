package com.yofun.controller;

import com.yofun.model.ProductType;
import com.yofun.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductTypeController {

    @Autowired
    ProductTypeService productTypeService;


    @RequestMapping(value = "/insertProducttype", method = RequestMethod.POST)
    public void insertProductType(ProductType productType) {
        productTypeService.insertProductType(productType);
    }

    @RequestMapping(value = "/findProductTypeById", method = RequestMethod.GET)
    public String findProductTypeById(int id, Model model) {
        ProductType productType = productTypeService.findProductTypeById(id);
        if(productType == null) {
            productType = new ProductType();
            productType.setParentId(-1);
        }
        model.addAttribute("productType", productType);
        return "producttypeadd";
    }
}
