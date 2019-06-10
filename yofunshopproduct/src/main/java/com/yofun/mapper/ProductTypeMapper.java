package com.yofun.mapper;

import com.yofun.model.ProductType;

public interface ProductTypeMapper {
    void insertProductType(ProductType productType);
    ProductType findProductTypeById(int id);
}
