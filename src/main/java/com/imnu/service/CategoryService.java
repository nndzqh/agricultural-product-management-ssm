package com.imnu.service;

import com.imnu.bean.po.Category;

import java.util.List;

/**
 * @author WenWangXin
 * @create 2022-06-24-20:17
 */
public interface CategoryService {

    

    void add(Category category);

    Boolean delete(int id);

    void update(Category category);

    List<Category> getPage(int page, int size,String name);

    List<Category> find(String name);

    /**
     * 根据分类id获取分类信息
     * @param categoryId 分类id
     * @return category
     */
    Category get(Integer categoryId);

    /**
     * 获取全部的分类信息
     * @return list
     */
    List<Category> getAll();
}
