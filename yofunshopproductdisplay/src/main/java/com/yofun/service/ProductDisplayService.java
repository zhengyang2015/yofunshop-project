package com.yofun.service;

import com.yofun.dao.ProductDisplayDao;
import com.yofun.model.Product;
import com.yofun.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDisplayService {

    @Autowired
    private ProductDisplayDao productDisplayDao;

    public List<Product> queryProductByVo(ProductVo productVo) {
        return productDisplayDao.queryProductByVo(productVo);
    }
}
