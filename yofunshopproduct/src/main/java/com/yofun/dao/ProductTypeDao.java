package com.yofun.dao;

import com.yofun.mapper.ProductTypeMapper;
import com.yofun.model.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeDao {

    @Autowired
    ProductTypeMapper productTypeMapper;

    public void insertProductType(ProductType productType) {
        productTypeMapper.insertProductType(productType);
    }

    public ProductType findProductTypeById(int id) {
        return productTypeMapper.findProductTypeById(id);
    }
}
