package com.imnu.service.impl;

import com.github.pagehelper.PageHelper;
import com.imnu.bean.po.Products;
import com.imnu.mapper.ProductsMapper;
import com.imnu.service.ProductsService;

import java.util.List;

/**
 * @author WenWangXin
 * @create 2022-06-25-1:10
 */
public class ProductsServiceImpl implements ProductsService {

    private ProductsMapper productsMapper;

    public void setProductsMapper(ProductsMapper productsMapper) {
        this.productsMapper = productsMapper;
    }

    @Override
    public void add(Products products) {
        productsMapper.add(products);
    }

    @Override
    public void delete(Integer productId) {
        productsMapper.delete(productId);
    }

    @Override
    public Products get(Integer productId) {
        return productsMapper.get(productId);

    }

    @Override
    public List<Products> getPage(int page, int size) {
        PageHelper.startPage(page,size);
        return productsMapper.getPage();
    }

    @Override
    public int deleteByCategroyId(int categoryid) {
        int cont=productsMapper.findbyCategory(categoryid);
        return cont;
    }


    @Override
    public void update(Products products) {
        productsMapper.update(products);
    }

    @Override
    public List<Products> getPageFind(int page, int size, String productsName) {
        PageHelper.startPage(page,size);
        return productsMapper.getPageFind(productsName);
    }

    @Override
    public List<Products> getAll() {
        return productsMapper.getAll();
    }

}
