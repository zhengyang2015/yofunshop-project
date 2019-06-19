package com.yofun.service;

import com.yofun.dao.ProductDao;
import com.yofun.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public void insertProduct(Product product) {
        productDao.insertProduct(product);
    }
}
