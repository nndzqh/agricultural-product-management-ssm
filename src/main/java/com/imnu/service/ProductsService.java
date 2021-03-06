package com.imnu.service;

import com.imnu.bean.po.Products;
import com.imnu.bean.vo.ProductsVo;

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

    List<ProductsVo> getPageVo(int page, int size);


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

    /**
     * 根据条件查询产品信息并分页显示
     * @param page 第几页
     * @param size 显示条数
     * @param productsName 查询条件
     * @return list
     */
    List<Products> getPageFind(int page, int size, String productsName);

    /**
     * 获取产品所以信息
     * @return list
     */
    List<Products> getAll();

}
