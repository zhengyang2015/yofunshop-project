package com.yofun.mapper;

import com.yofun.model.Product;

public interface ProductMapper {
    void insertProduct(Product product);
    void auditProduct(Product product);
    Product findProductById(int id);
}
