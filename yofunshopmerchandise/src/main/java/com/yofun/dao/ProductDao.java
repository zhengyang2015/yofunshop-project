package com.yofun.dao;

import com.yofun.mapper.ProductMapper;
import com.yofun.model.Product;
import com.yofun.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void updateProduct(Product product) {
        productMapper.updateProduct(product);
    }

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
