package com.yofun.dao;

import com.yofun.mapper.ProductDetailsMapper;
import com.yofun.model.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDetailsDao {

    @Autowired
    ProductDetailsMapper productDetailsMapper;

    public void insertProductDetails(ProductDetails productDetails) {
        productDetailsMapper.insertProductDetails(productDetails);
    }
}
