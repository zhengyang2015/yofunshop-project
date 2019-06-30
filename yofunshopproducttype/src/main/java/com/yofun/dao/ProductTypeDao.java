package com.yofun.dao;

import com.yofun.mapper.ProductTypeMapper;
import com.yofun.model.ProductType;
import com.yofun.vo.ProductTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductTypeDao {

    @Autowired
    ProductTypeMapper productTypeMapper;

    public void insertProductType(ProductType productType) {
        productTypeMapper.insertProductType(productType);
    }

    public ProductType findProductTypeById(int id) {
        return productTypeMapper.findProductTypeById(id);
    }

    public void updateProductType(ProductType productType) {
        productTypeMapper.updateProductType(productType);
    }

    public List<ProductType> queryProductTypeByVo(ProductTypeVo productTypeVo) {
        return productTypeMapper.queryProductTypeByVo(productTypeVo);
    }

    public void deleteProductTypeById(int id) {
        productTypeMapper.deleteProductTypeById(id);
    }

    public List<ProductType> findAllProductType() {
        return productTypeMapper.findAllProductType();
    }
}
