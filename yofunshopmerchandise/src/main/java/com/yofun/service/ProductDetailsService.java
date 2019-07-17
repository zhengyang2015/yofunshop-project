package com.yofun.service;

import com.yofun.dao.ProductDetailsDao;
import com.yofun.model.ProductDetails;
import com.yofun.utils.SolrUtil;
import org.apache.solr.client.solrj.SolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductDetailsService {

    @Autowired
    private SolrClient solrClient;

    @Autowired
    ProductDetailsDao productDetailsDao;

    public void insertProductDetails(ProductDetails productDetails) {
        try {
            productDetailsDao.insertProductDetails(productDetails);

            Map<String, Object> mapValue = new HashMap<>();
            mapValue.put("id", productDetails.getProductId());
            mapValue.put("productdescription", productDetails.getProductDescription());

            SolrUtil.addIndex(solrClient, mapValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ProductDetails findByProductId(int productId) {
        return productDetailsDao.findByProductId(productId);
    }
}
