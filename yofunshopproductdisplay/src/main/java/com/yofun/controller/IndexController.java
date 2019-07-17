package com.yofun.controller;

import com.yofun.model.Product;
import com.yofun.model.ProductDetails;
import com.yofun.model.ProductType;
import com.yofun.service.DisplayProductService;
import com.yofun.service.DisplayProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private DisplayProductTypeService displayProductTypeService;

    @Autowired
    private DisplayProductService displayProductService;

    @RequestMapping(value = "/listProduct",method = RequestMethod.GET)
    public String listProduct(@RequestParam int productTypeId, Model model) {
        List<ProductType> productTypes = displayProductTypeService.findAllProductType();
        model.addAttribute("productTypes", productTypes);

        if(productTypeId == -1) {
            productTypeId = productTypes.get(0).getId();
        }

        List<Product> products = displayProductService.findAllProduct(productTypeId);
        model.addAttribute("products", products);

        return "list";
    }

    @RequestMapping(value = "/searchProduct",method = RequestMethod.GET)
    public String searchProduct(Model model, String keyword) {
        List<Product> products = displayProductService.searchProduct(keyword);
        model.addAttribute("products", products);
        return "list";
    }

    @RequestMapping(value = "/toProductDetails",method = RequestMethod.GET)
    public String toProductDetails(int productId, Model model) {
        List<ProductType> productTypes = displayProductTypeService.findAllProductType();
        model.addAttribute("productTypes", productTypes);

        Product product = displayProductService.findProductById(productId);
        model.addAttribute("product", product);

        ProductDetails productDetails = displayProductService.findProductDetailsByProductId(productId);
        model.addAttribute("productDetails", productDetails);

        return "productdeatils";
    }
}
