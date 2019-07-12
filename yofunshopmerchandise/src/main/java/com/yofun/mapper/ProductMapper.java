package com.yofun.mapper;

import com.yofun.model.Product;
import com.yofun.vo.ProductVo;

import java.util.List;
import java.util.Map;

public interface ProductMapper {
    void insertProduct(Product product);
    void auditProduct(Product product);
    Product findProductById(int id);
    void updateProduct(Product product);
    void deleteProductById(int id);
    List<Product> queryProductByVo(ProductVo productVo);
    void updateProductStatus(Product product);
    List<Product> queryProductByIds(Map<String, Object> map);
}
