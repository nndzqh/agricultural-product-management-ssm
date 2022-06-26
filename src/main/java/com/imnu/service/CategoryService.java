package com.imnu.service;

import com.imnu.bean.Category;

import java.util.List;

/**
 * @author WenWangXin
 * @create 2022-06-24-20:17
 */
public interface CategoryService {

    

    void add(Category category);

    Boolean delete(int id);

    void update(Category category);

    List<Category> getPage(int page, int size);

    Category find(String name);
}
