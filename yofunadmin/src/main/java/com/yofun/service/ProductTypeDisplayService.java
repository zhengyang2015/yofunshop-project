package com.yofun.service;

import com.yofun.model.ProductType;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "yofunshopproducttype")
@Service
public interface ProductTypeDisplayService {

    @RequestMapping(value = "/findAllProductType",method = RequestMethod.GET)
    List<ProductType> findAllProductType();

    @RequestMapping(value = "/integrateInsertProducttype",method = RequestMethod.POST)
    void insertProductType(@RequestBody ProductType productType);

    @RequestMapping(value = "/integrateFindProductTypeById", method = RequestMethod.GET)
    ProductType findProductTypeById(@RequestParam(value = "id") int id);

}
