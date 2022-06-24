package com.imnu.controller;

import com.imnu.service.ProductsService;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/**
 * @author WenWangXin
 * @create 2022-06-25-2:26
 */
public class ProductsController {

    @Resource
    @Qualifier("ProductsServiceImpl")
    private ProductsService productsService;

}
