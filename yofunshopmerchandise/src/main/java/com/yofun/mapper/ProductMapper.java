package com.yofun.mapper;

import com.yofun.model.Product;
import com.yofun.vo.ProductVo;

import java.util.List;

public interface ProductMapper {
    void insertProduct(Product product);
    void auditProduct(Product product);
    Product findProductById(int id);
    void updateProduct(Product product);
    void deleteProductById(int id);
    List<Product> queryProductByVo(ProductVo productVo);
}
