package com.imnu.controller;

import com.github.pagehelper.PageInfo;
import com.imnu.bean.po.Category;
import com.imnu.bean.po.Products;
import com.imnu.bean.vo.ProductsVo;
import com.imnu.service.CategoryService;
import com.imnu.service.FileService;
import com.imnu.service.ProductsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author WenWangXin
 * @create 2022-06-25-2:26
 */
@Controller
@RequestMapping("products")
public class ProductsController {

    @Resource
    @Qualifier("ProductsServiceImpl")
    private ProductsService productsService;

    @Resource
    @Qualifier("CategoryServiceImpl")
    private CategoryService categoryService;

    @Resource
    @Qualifier("FileService")
    private FileService fileService;

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String add(Products products,
                      @RequestParam(value = "farm", required = false) CommonsMultipartFile farm,
                      HttpServletRequest request){

        String newFilePath = fileService.fileUpdate(farm,request);
        products.setImg(newFilePath);
        products.setState(0);
        products.setCreateTime(new Date());
        products.setUpdateTime(new Date());
        productsService.add(products);
        return "redirect:/products/getPage";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String delete(Integer productId){
        productsService.delete(productId);
        return "redirect:/products/getPage";
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public String get(Integer productId, Model model){
        Products products = productsService.get(productId);
        ProductsVo productsVo = new ProductsVo();
        BeanUtils.copyProperties(products,productsVo);
        Category category = categoryService.get(productId);
        productsVo.setCategoryName(category.getName());
        List<Category> categoryList = categoryService.getAll();
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("products",productsVo);
        return "update";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(Products products){
        products.setUpdateTime(new Date());
        productsService.update(products);
        return "redirect:/products/getPage";
    }

    @RequestMapping(value = "getPage", method = RequestMethod.GET)
    public String getPage(@RequestParam(defaultValue = "1") int page,
                          @RequestParam(defaultValue = "5")int size, Model model){
        if (page < 1){
            page = 1;
        }
        List<Products> pageList = productsService.getPage(page,size);
        List<ProductsVo> productsVoList = pageList.stream().map((item) ->{
            ProductsVo productsVo = new ProductsVo();
            BeanUtils.copyProperties(item, productsVo);
            Category category = categoryService.get(item.getCategoryId());
            productsVo.setCategoryName(category.getName());
            return productsVo;
        }).collect(Collectors.toList());
        PageInfo<ProductsVo> pageInfo = new PageInfo<>(productsVoList);
        model.addAttribute("pageInfo",pageInfo);
        System.out.println(pageList);
        return "index";
    }

    @RequestMapping(value = "getPageFind", method = RequestMethod.POST)
    public String getPageFind(@RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "5")int size,
                              String productsName, Model model){
        List<Products> pageList = productsService.getPageFind(page,size,productsName);
        List<ProductsVo> productsVoList = pageList.stream().map((item) -> {
            ProductsVo productsVo = new ProductsVo();
            BeanUtils.copyProperties(item, productsVo);
            Category category = categoryService.get(item.getCategoryId());
            productsVo.setCategoryName(category.getName());
            return productsVo;
        }).collect(Collectors.toList());
        PageInfo<ProductsVo> pageInfo = new PageInfo<>(productsVoList);
        model.addAttribute("pageInfo",pageInfo);
        return "index";
    }

    @RequestMapping("findCategoryName")
    public String findCategoryName(Model model){
        List<Category> categoryList = categoryService.getAll();
        model.addAttribute("categoryList",categoryList);
        return "add";
    }

}
