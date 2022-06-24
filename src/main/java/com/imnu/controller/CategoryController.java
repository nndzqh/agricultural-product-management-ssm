package com.imnu.controller;

import com.imnu.service.CategoryService;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/**
 * @author WenWangXin
 * @create 2022-06-25-2:28
 */
public class CategoryController {

    @Resource
    @Qualifier("CategoryServiceImpl")
    private CategoryService categoryService;
}
