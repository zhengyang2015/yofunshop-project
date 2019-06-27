package com.yofun.controller;

import com.yofun.model.Product;
import com.yofun.service.ProductDisplayService;
import com.yofun.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProductDisplayController {

    @Autowired
    private ProductDisplayService productDisplayService;

    @RequestMapping(value = "/queryProductByVo", method = RequestMethod.GET)
    public String queryProductByVo(Model model) {
        ProductVo productVo = new ProductVo();
        List<Product> products = productDisplayService.queryProductByVo(productVo);
        model.addAttribute("products", products);
        return "products";
    }
}
