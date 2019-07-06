package com.yofun.action;

import com.yofun.model.Product;
import com.yofun.service.ProductDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
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
        model.addAttribute("productTypeId", productTypeId);
        return "products";
    }

    @RequestMapping(value = "/findProductById", method = RequestMethod.GET)
    public String findProductById(int id, Model model) {
        Product product = productDisplayService.findProductById(id);
        model.addAttribute("product", product);
        return "productview";
    }

    @RequestMapping(value = "/insertProduct", method = RequestMethod.POST)
    public void insertProduct(Product product) {
        productDisplayService.insertProduct(product);
    }

    @RequestMapping(value = "/toInsertProduct", method = RequestMethod.GET)
    public String toInsertProduct(int productTypeId, Model model) {
        model.addAttribute("productTypeId", productTypeId);
        return "productinsert";
    }

    @RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
    public void updateProduct(Product product) {
        productDisplayService.updateProduct(product);
    }

    @RequestMapping(value = "/toUpdateProduct", method = RequestMethod.GET)
    public String toUpdateProduct(int id, Model model) {
        Product product = productDisplayService.findProductById(id);
        model.addAttribute("product", product);
        return "productupdate";
    }

    @RequestMapping(value = "/deleteProductById", method = RequestMethod.GET)
    public void deleteProductById(int id) {
        productDisplayService.deleteProductById(id);
    }

}
