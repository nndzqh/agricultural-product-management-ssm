package com.imnu.mapper;

import com.imnu.bean.po.Products;
import com.imnu.bean.vo.ProductsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 63547
* @description 针对表【products(农产品表)】的数据库操作Mapper
* @createDate 2022-06-24 20:12:51
* @Entity com.imnu.bean.po.Products
*/
public interface ProductsMapper {

    /**
     * 添加产品
     * @param products 产品实体类
     */
    void add(Products products);

    /**
     * 根据产品id删除产品信息
     * @param productId 产品id
     */
    void delete(@Param("productId") Integer productId);

    /**
     * 根据产品id获取产品信息
     * @param productId 产品id
     * @return products
     */
    Products get(@Param("productId") Integer productId);

    /**
     * 查询全部产品信息
     * @return list
     */
    List<Products> getPage();

    List<ProductsVo> getPageVo();


    /**
     * 修改产品信息
     * @param products 产品
     */
    void update(Products products);



    /**
     * 根据categoryid查询
     * @return categoryid
     */
    int findbyCategory(int categoryid);

    /**
     * 根据条件查询产品信息
     * @param productsName
     * @return
     */
    List<Products> getPageFind(String productsName);

    /**
     * 获得所以的产品信息
     * @return list
     */
    List<Products> getAll();

}
