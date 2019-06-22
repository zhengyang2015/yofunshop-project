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

    public void auditProduct(Product product) {
        productMapper.auditProduct(product);
    }

    public Product findProductById(int id) {
        return productMapper.findProductById(id);
    }

}
