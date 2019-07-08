package com.yofun.service;

import com.yofun.dao.ProductDao;
import com.yofun.model.Product;
import com.yofun.utils.SolrUtil;
import com.yofun.vo.ProductVo;
import org.apache.solr.client.solrj.SolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    @Autowired
    private SolrClient solrClient;

    @Autowired
    private ProductDao productDao;

    public void insertProduct(Product product) {
        try {
            productDao.insertProduct(product);

            Map<String, Object> mapValue = new HashMap<>();
            mapValue.put("id", product.getId());
            mapValue.put("producttitle", product.getProductTitle());

            SolrUtil.addIndex(solrClient, mapValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public void updateProductStatus(int id, int productStatus) {
        Product product = new Product();
        product.setId(id);
        product.setProductStatus(productStatus);
        productDao.updateProductStatus(product);
    }
}
