package com.yofun.dao;

import com.yofun.mapper.ProductMapper;
import com.yofun.model.Product;
import com.yofun.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@CacheConfig(cacheNames = "productchache")
public class ProductDao {

    @Autowired
    private ProductMapper productMapper;

    @Cacheable(key = "#id")
    public void insertProduct(Product product) {
        productMapper.insertProduct(product);
    }

    public void auditProduct(Product product) {
        productMapper.auditProduct(product);
    }

    @Cacheable
    public Product findProductById(int id) {
        System.out.println("Get into findProductById");
        return productMapper.findProductById(id);
    }

    @CachePut(key = "#id")
    public void updateProduct(Product product) {
        productMapper.updateProduct(product);
    }

    @CacheEvict(key = "#id")
    public void deleteProductById(int id) {
        productMapper.deleteProductById(id);
    }

    public List<Product> queryProductByVo(ProductVo productVo) {
        return productMapper.queryProductByVo(productVo);
    }

    public void updateProductStatus(Product product) {
        productMapper.updateProductStatus(product);
    }

    public List<Product> queryProductByIds(List<String> ids) {
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        return productMapper.queryProductByIds(map);
    }
}
