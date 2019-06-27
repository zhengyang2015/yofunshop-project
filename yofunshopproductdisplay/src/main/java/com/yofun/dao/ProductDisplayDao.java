package com.yofun.dao;

import com.yofun.mapper.ProductDisplayMapper;
import com.yofun.model.Product;
import com.yofun.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDisplayDao {

    @Autowired
    private ProductDisplayMapper productDisplayMapper;

    public List<Product> queryProductByVo(ProductVo productVo) {
        return productDisplayMapper.queryProductByVo(productVo);
    }
}
