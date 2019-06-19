package com.yofun.dao;

import com.yofun.mapper.ProductMapper;
import com.yofun.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDao {

    @Autowired
    private ProductMapper productMapper;

    public void insertProduct(Product product) {
        productMapper.insertProduct(product);
    }

}
