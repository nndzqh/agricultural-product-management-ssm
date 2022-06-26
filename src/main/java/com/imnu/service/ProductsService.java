package com.imnu.service;

import com.imnu.bean.po.Products;

import java.util.List;

/**
 * @author WenWangXin
 * @create 2022-06-24-20:16
 */
public interface ProductsService {
    /**
     * 添加产品
     * @param products 产品实体类
     */
    void add(Products products);

    /**
     * 删除
     * @param productId 产品id
     */
    void delete(Integer productId);

    /**
     * 根据产品id获取产品信息
     * @param productId 产品id
     * @return products
     */
    Products get(Integer productId);

    /**
     * 分页查询全部产品
     * @param page 第几页
     * @param size 显示条数
     * @return list
     */
    List<Products> getPage(int page, int size);



    /**
     * 删除
     * @param categoryid 种类id
     */
    int deleteByCategroyId(int categoryid);

    /**
     * 修改产品信息
     * @param products 产品
     */
    void update(Products products);


}
