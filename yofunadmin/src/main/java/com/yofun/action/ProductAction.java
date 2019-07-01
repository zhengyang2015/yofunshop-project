package com.yofun.action;

import com.yofun.model.Product;
import com.yofun.service.ProductDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductAction {

    @Autowired
    private ProductDisplayService productDisplayService;

    @RequestMapping(value = "/findAllProductByType",method = RequestMethod.GET)
    public String findAllProductByType(@RequestParam int productTypeId, Model model) {
        List<Product> products = productDisplayService.findAllProduct(productTypeId);
        model.addAttribute("products", products);
        return "products";
    }
}
