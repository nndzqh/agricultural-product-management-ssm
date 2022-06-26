package com.imnu.service.impl;

import com.github.pagehelper.PageHelper;
import com.imnu.bean.Category;
import com.imnu.mapper.CategoryMapper;
import com.imnu.service.CategoryService;
import com.imnu.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author WenWangXin
 * @create 2022-06-24-22:05
 */
public class CategoryServiceImpl implements CategoryService {

    private CategoryMapper categoryMapper;
    @Autowired
    private ProductsService productsService;

    public void setCategoryMapper(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public void add(Category category) {
        categoryMapper.add(category);
    }

    @Override
    public Boolean delete(int id) {
         int count=productsService.deleteByCategroyId(id);
         if(count>1){
             return false;
         }else {
             categoryMapper.delecte(id);
             return true;
         }
    }

    @Override
    public void update(Category category) {
        categoryMapper.update(category);
    }

    @Override
    public List<Category> getPage(int page, int size) {
        PageHelper.startPage(page,size);
        return categoryMapper.getPage();
    }

    @Override
    public Category find(String name) {
        Category category=categoryMapper.find(name);
        return category;
    }
}
