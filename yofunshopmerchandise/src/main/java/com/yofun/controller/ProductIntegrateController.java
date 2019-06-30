package com.yofun.controller;

import com.yofun.model.Product;
import com.yofun.service.ProductService;
import com.yofun.vo.CustomProduct;
import com.yofun.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
