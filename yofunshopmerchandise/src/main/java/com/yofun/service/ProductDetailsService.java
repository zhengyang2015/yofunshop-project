package com.yofun.service;

import com.yofun.dao.ProductDetailsDao;
import com.yofun.model.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailsService {

    @Autowired
    ProductDetailsDao productDetailsDao;

    public void insertProductDetails(ProductDetails productDetails) {
        productDetailsDao.insertProductDetails(productDetails);
    }
}
