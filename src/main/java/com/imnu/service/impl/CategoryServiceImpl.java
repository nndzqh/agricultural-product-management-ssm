package com.imnu.service.impl;

import com.imnu.mapper.CategoryMapper;
import com.imnu.service.CategoryService;

/**
 * @author WenWangXin
 * @create 2022-06-24-22:05
 */
public class CategoryServiceImpl implements CategoryService {

    private CategoryMapper categoryMapper;

    public void setCategoryMapper(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }
}
