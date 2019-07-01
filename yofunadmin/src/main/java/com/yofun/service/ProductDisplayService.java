package com.yofun.service;

import com.yofun.model.Product;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "yofunshopmerchandise")
@Service
public interface ProductDisplayService {

    @RequestMapping(value = "/listProduct",method = RequestMethod.GET)
    List<Product> findAllProduct(@RequestParam(value = "productTypeId") int productTypeId);

}
