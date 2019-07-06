package com.yofun.controller;

import com.yofun.model.Product;
import com.yofun.service.ProductService;
import com.yofun.vo.CustomProduct;
import com.yofun.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@EnableEurekaClient
@RestController
public class ProductIntegrateController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String testCloud(@RequestParam String name){
        return "Hi " + name + ", I am from port:";
    }

    @RequestMapping(value = "/listProduct",method = RequestMethod.GET)
    public List<Product> listProduct(int productTypeId) {
        CustomProduct customProduct = new CustomProduct();
        customProduct.setProductTypeId(productTypeId);
        ProductVo productVo = new ProductVo();
        productVo.setCustomProduct(customProduct);
        List<Product> products = productService.queryProductByVo(productVo);
        return products;
    }

    @RequestMapping(value = "/integrateInsertProduct", method = RequestMethod.POST)
    public void insertProduct(@RequestBody Product product) {
        product.setCreatedAt(LocalDateTime.now());
        product.setSellNumber(0);
        product.setProductStatus(0);
        productService.insertProduct(product);
    }

    @RequestMapping(value = "/integrateFindProductById", method = RequestMethod.GET)
    public Product findProductById(@RequestParam(value = "id") int id) {
        return productService.findProductById(id);
    }

    @RequestMapping(value = "/integrateUpdateProduct", method = RequestMethod.POST)
    public void updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
    }

    @RequestMapping(value = "/integrateDeleteProductById", method = RequestMethod.GET)
    public void deleteProductById(@RequestParam(value = "id") int id) {
        productService.deleteProductById(id);
    }
}
