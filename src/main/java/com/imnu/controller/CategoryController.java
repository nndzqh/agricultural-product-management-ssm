package com.imnu.controller;

import com.github.pagehelper.PageInfo;
import com.imnu.bean.Category;
import com.imnu.service.CategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ShenChao
 * @create 2022-06-25-2:28
 */
public class CategoryController {

    @Resource
    @Qualifier("CategoryServiceImpl")
    private CategoryService categoryService;
    /**
     * 添加种类
     * @param category
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(Category category){
        categoryService.add(category);
        return "";
    }
    /**
     * 删除种类
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public Map<String,Boolean> delete(int id){
        Map<String, Boolean> map=new HashMap<String, Boolean>();
        Boolean flag=categoryService.delete(id);
        map.put("Boolean",flag);
       return map;
    }
    /**
     * 删除种类
     * @param category
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public String update(Category category){
        categoryService.update(category);
        return "";
    }
    /**
     * 分页查询
     * @param page,size
     * @return
     */
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public String page(@RequestParam(defaultValue = "1") int page,
                       @RequestParam(defaultValue = "5")int size, Model model){
        List<Category> list=categoryService.getPage(page,size);
        PageInfo pageInfo=new PageInfo(list);
        model.addAttribute(pageInfo);
        return "";
    }
    /**
     * 分页查询
     * @param name
     * @return
     */
    @RequestMapping("/find")
    public String find(String name,Model model){
        Category category=categoryService.find(name);
        model.addAttribute("category",category);
        return "";
    }
}
