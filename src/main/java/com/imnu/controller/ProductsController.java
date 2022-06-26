package com.imnu.controller;

import com.github.pagehelper.PageInfo;
import com.imnu.bean.Products;
import com.imnu.service.ProductsService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author WenWangXin
 * @create 2022-06-25-2:26
 */
@Controller()
@RequestMapping("products")
public class ProductsController {

    @Resource
    @Qualifier("ProductsServiceImpl")
    private ProductsService productsService;

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String add(Products products){
        productsService.add(products);
        return "redirect:";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String delete(Integer productId){
        productsService.delete(productId);
        return "redirect:";
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public String get(Integer productId, Model model){
        Products products = productsService.get(productId);
        if (!Objects.isNull(products)){
            model.addAttribute("products",products);
            return "";
        }else {
            return "";
        }
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(Products products){
        productsService.update(products);
        return "";
    }

    @RequestMapping(value = "getPage", method = RequestMethod.GET)
    public String getPage(@RequestParam(defaultValue = "1") int page,
                          @RequestParam(defaultValue = "10")int size, Model model){
        List<Products> pageList = productsService.getPage(page,size);
        PageInfo pageInfo = new PageInfo(pageList);
        model.addAttribute("pageInfo",pageInfo);
        return "";
    }


}
