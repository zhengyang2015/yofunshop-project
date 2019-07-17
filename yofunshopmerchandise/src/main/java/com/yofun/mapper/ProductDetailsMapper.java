package com.yofun.mapper;

import com.yofun.model.ProductDetails;

public interface ProductDetailsMapper {
    void insertProductDetails(ProductDetails productDetails);
    ProductDetails findByProductId(int productId);
}
