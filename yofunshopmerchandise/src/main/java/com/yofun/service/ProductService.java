package com.yofun.service;

import com.yofun.dao.ProductDao;
import com.yofun.model.Product;
import com.yofun.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public void insertProduct(Product product) {
        productDao.insertProduct(product);
    }

    public void auditProduct(int id, int auditStatus) {
        Product product = new Product();
        product.setId(id);
        product.setAuditStatus(auditStatus);
        product.setAuditAt(LocalDateTime.now());
        productDao.auditProduct(product);
    }

    public Product findProductById(int id) {
        return productDao.findProductById(id);
    }

    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

    public void deleteProductById(int id) {
        productDao.deleteProductById(id);
    }

    public List<Product> queryProductByVo(ProductVo productVo) {
        return productDao.queryProductByVo(productVo);
    }
}
