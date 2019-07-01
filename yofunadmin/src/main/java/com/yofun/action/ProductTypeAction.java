package com.yofun.action;

import com.yofun.model.ProductType;
import com.yofun.service.ProductTypeDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProductTypeAction {

    @Autowired
    ProductTypeDisplayService displayProductTypeService;

    @RequestMapping(value = "/findAllProductType",method = RequestMethod.GET)
    public String findAllProductType(Model model) {
        List<ProductType> productTypes = displayProductTypeService.findAllProductType();
        model.addAttribute("productTypes", productTypes);
        return "producttypes";
    }

    @RequestMapping(value = "/listProductTypeByProduct",method = RequestMethod.GET)
    public String listProductTypeByProduct(Model model) {
        List<ProductType> productTypes = displayProductTypeService.findAllProductType();
        model.addAttribute("productTypes", productTypes);
        return "producttypebyproduct";
    }
}
