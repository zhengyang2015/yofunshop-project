package com.yofun.mapper;

import com.yofun.model.ProductType;
import com.yofun.vo.ProductTypeVo;

import java.util.List;

public interface ProductTypeMapper {
    void insertProductType(ProductType productType);
    ProductType findProductTypeById(int id);
    void updateProductType(ProductType productType);
    List<ProductType> queryProductTypeByVo(ProductTypeVo productTypeVo);
    void deleteProductTypeById(int id);
    List<ProductType> findAllProductType();
}
