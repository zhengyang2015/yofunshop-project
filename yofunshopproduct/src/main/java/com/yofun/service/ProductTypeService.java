package com.yofun.service;

import com.yofun.dao.ProductTypeDao;
import com.yofun.model.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeService {
    @Autowired
    ProductTypeDao productTypeDao;

    public void insertProductType(ProductType productType) {
        productTypeDao.insertProductType(productType);
    }

    public ProductType findProductTypeById(int id) {
        return productTypeDao.findProductTypeById(id);
    }
}
