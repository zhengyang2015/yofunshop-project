package com.yofun.mapper;

import com.yofun.model.Product;
import com.yofun.vo.ProductVo;

import java.util.List;

public interface ProductDisplayMapper {
    List<Product> queryProductByVo(ProductVo productVo);
}
