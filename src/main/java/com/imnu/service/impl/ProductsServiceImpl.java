package com.imnu.service.impl;

import com.imnu.mapper.ProductsMapper;
import com.imnu.service.ProductsService;

/**
 * @author WenWangXin
 * @create 2022-06-25-1:10
 */
public class ProductsServiceImpl implements ProductsService {

    private ProductsMapper productsMapper;

    public void setProductsMapper(ProductsMapper productsMapper) {
        this.productsMapper = productsMapper;
    }
}
