package com.yofun.controller;

import com.yofun.model.Product;
import com.yofun.service.ProductService;
import com.yofun.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;

@EnableEurekaClient
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/insertProduct", method = RequestMethod.POST)
    public void insertProduct(Product product) {
        product.setCreatedAt(LocalDateTime.now());
        product.setSellNumber(0);
        product.setProductStatus(0);
        productService.insertProduct(product);
    }

    @RequestMapping(value = "/toProductRegister", method = RequestMethod.GET)
    public String toProductRegister(Product product) {
        return "productregister";
    }

    @RequestMapping(value = "/auditProduct", method = RequestMethod.POST)
    public void auditProduct(int id, int auditStatus) {
        productService.auditProduct(id, auditStatus);
    }

    @RequestMapping(value = "/toAuditProduct", method = RequestMethod.GET)
    public String toProductRegister(int id, Model model) {
        Product product = productService.findProductById(id);
        if(product == null) {
            throw new RuntimeException("No product find by id : " + id + " for audit");
        }
        model.addAttribute("product", product);
        return "productaudit";
    }

    @RequestMapping(value = "/queryProductByVo", method = RequestMethod.GET)
    public String queryProductByVo(Model model) {
        ProductVo productVo = new ProductVo();
        List<Product> products = productService.queryProductByVo(productVo);
        model.addAttribute("products", products);
        return "products";
    }

    @RequestMapping(value = "/findProductById", method = RequestMethod.GET)
    public String findProductById(int id, Model model) {
        Product product = productService.findProductById(id);
        model.addAttribute("product", product);
        return "productview";
    }

    @RequestMapping(value = "/toUpdateProduct", method = RequestMethod.GET)
    public String toUpdateProduct(int id, Model model) {
        Product product = productService.findProductById(id);
        model.addAttribute("product", product);
        return "productupdate";
    }

    @RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
    public void updateProduct(Product product, Model model) {
        productService.updateProduct(product);
    }

    @RequestMapping(value = "/deleteProductById", method = RequestMethod.GET)
    public String deleteProductById(int id) {
        productService.deleteProductById(id);
        return "products";
    }

    @RequestMapping(value = "/updateProductStatus", method = RequestMethod.GET)
    public void updateProductStatus(int id, int productStatus) {
        productService.updateProductStatus(id, productStatus);
    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ResponseBody
    public String testCloud(@RequestParam String name){
        return "Hi " + name + ", I am from port:";
    }
}
