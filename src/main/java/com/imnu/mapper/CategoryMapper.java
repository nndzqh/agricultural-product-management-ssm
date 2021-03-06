package com.imnu.mapper;

import com.imnu.bean.po.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 63547
* @description 针对表【category(分类表)】的数据库操作Mapper
* @createDate 2022-06-24 20:11:58
* @Entity com.imnu.bean.po.Category
*/
public interface CategoryMapper {


    void add(Category category);

    void delecte(int id);

    void update(Category category);

    /**
     *
     * @param name
     * @return
     */
    List<Category> getPage(@Param("name") String name);

    List<Category> find(@Param("name") String name);

    /**
     * 根据id获取分类信息
     * @param categoryId 分类id
     * @return category
     */
    Category get(@Param("categoryId") Integer categoryId);

    /**
     * 获取全部的分类信息
     * @return list
     */
    List<Category> getAll();
}
