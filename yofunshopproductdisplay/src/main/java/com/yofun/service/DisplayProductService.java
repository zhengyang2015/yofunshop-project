package com.yofun.service;

import com.yofun.model.Product;
import com.yofun.model.ProductDetails;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "yofunshopmerchandise")
@Service
public interface DisplayProductService {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String sayHiFromClient(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/listProduct",method = RequestMethod.GET)
    List<Product> findAllProduct(@RequestParam(value = "productTypeId") int productTypeId);

    @RequestMapping(value = "/integrateSearchProduct", method = RequestMethod.GET)
    List<Product> searchProduct(@RequestParam(value = "keyword") String keyword);

    @RequestMapping(value = "/integrateFindProductById", method = RequestMethod.GET)
    Product findProductById(@RequestParam(value = "id") int id);

    @RequestMapping(value = "/integrateFindProductDetailsByProductId", method = RequestMethod.GET)
    ProductDetails findProductDetailsByProductId(@RequestParam(value = "productId") int productId);
}
