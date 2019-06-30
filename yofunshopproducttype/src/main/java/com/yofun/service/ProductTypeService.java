package com.yofun.service;

import com.yofun.dao.ProductTypeDao;
import com.yofun.model.ProductType;
import com.yofun.vo.ProductTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService {
    @Autowired
    ProductTypeDao productTypeDao;

    public void insertProductType(ProductType productType) {
        productTypeDao.insertProductType(productType);
    }

    public ProductType findProductTypeById(int id) {
        return productTypeDao.findProductTypeById(id);
    }

    public void updateProductType(ProductType productType) {
        productTypeDao.updateProductType(productType);
    }

    public List<ProductType> queryProductTypeByVo(ProductTypeVo productTypeVo) {
        return productTypeDao.queryProductTypeByVo(productTypeVo);
    }

    public void deleteProductTypeById(int id) {
        productTypeDao.deleteProductTypeById(id);
    }

    public List<ProductType> findAllProductType() {
        return productTypeDao.findAllProductType();
    }
}
