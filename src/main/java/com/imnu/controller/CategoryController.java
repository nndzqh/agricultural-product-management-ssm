package com.imnu.controller;

import com.github.pagehelper.PageInfo;
import com.imnu.bean.po.Category;
import com.imnu.service.CategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ShenChao
 * @create 2022-06-25-2:28
 */
@Controller()
@RequestMapping("/category")
public class CategoryController {

    @Resource
    @Qualifier("CategoryServiceImpl")
    private CategoryService categoryService;
    /**
     * 添加种类
     * @param name,sort
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(@RequestParam("name") String name,@RequestParam("sort") Integer sort){
        Category category = new Category();
        category.setSort(sort);
        category.setName(name);
        categoryService.add(category);
        return "redirect:/category/page";
    }
    /**
     * 删除种类
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Boolean> delete(@RequestParam("id") Integer id){
        System.out.println("FFFFFFFFFFFFFF"+id);
        Boolean flag=categoryService.delete(id);
        Map<String,Boolean> map=new HashMap<String, Boolean>();
        //model.addAttribute("flag",flag);
        if(flag){
            map.put("flag",true);
        }else {
            map.put("flag",false);
        }
        System.out.println(map);
       return map;
    }
    /**
     * 更新种类
     * @param name,sort
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(@RequestParam("name") String name,@RequestParam("sort") Integer sort,@RequestParam("id") Integer id){
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        category.setSort(sort);
        categoryService.update(category);
        return "redirect:/category/page";
    }
    /**
     * 分页查询
     * @param page,size name
     * @return
     */
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public String page(@RequestParam(defaultValue = "1") int page,
                       @RequestParam(defaultValue = "5")int size, Model model,String name){
        List<Category> list=categoryService.getPage(page,size,name);
        PageInfo pageInfo=new PageInfo(list);
        model.addAttribute("pageInfo",pageInfo);
        return "index";
    }

    /**
     * 通过id查询
     * @param  id
     * @return category
     */
    @RequestMapping(value = "/getById",method = RequestMethod.GET)
    public String getByid(@RequestParam("id") Integer id,Model model){
        Category category = categoryService.get(id);
        model.addAttribute("category",category);
        return "updateCategory";
    }
}
