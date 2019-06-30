package com.yofun.service;

import com.yofun.model.ProductType;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "yofunshopproducttype")
@Service
public interface DisplayProductTypeService {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String sayHiFromClient(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/findAllProductType",method = RequestMethod.GET)
    List<ProductType> findAllProductType();
}
