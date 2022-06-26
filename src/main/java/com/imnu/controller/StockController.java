package com.imnu.controller;

import com.github.pagehelper.PageInfo;
import com.imnu.bean.vo.StockVo;
import com.imnu.service.StockService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author WenWangXin
 * @create 2022-06-25-2:27
 */
@Controller
@RequestMapping("/stock")
public class StockController {

    @Resource
    @Qualifier("StockServiceImpl")
    private StockService stockService;

    /**
     * 分页带查询功能
     *
     * @param page
     * @param size
     * @param model
     * @return
     */
    @RequestMapping(value = "/getPage", method = RequestMethod.GET)
    public String getPage(@RequestParam(defaultValue = "1") int page,
                          @RequestParam(defaultValue = "5") int size,
                          Model model) {
        List<StockVo> pageList = stockService.getPage(page, size);
        PageInfo pageInfo = new PageInfo(pageList);
        model.addAttribute("pageInfo", pageInfo);
        return "index";
    }

    /**
     * 模糊查询
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "getPageFind", method = RequestMethod.POST)
    public String getPageFind(@RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "5") int size,
                              String productsName, Model model) {

        List<StockVo> pageList = stockService.getPageFind(page, size, productsName);
        PageInfo<StockVo> pageInfo = new PageInfo<>(pageList);
        model.addAttribute("pageInfo", pageInfo);
        return "index";
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public String get(Integer stockId, Model model) {
        StockVo stockVo1 = stockService.get(stockId);
        StockVo stockVo2 = new StockVo();
        BeanUtils.copyProperties(stockVo1, stockVo2);
        StockVo stockVo = stockService.get(stockId);
        stockVo2.setName(stockVo.getName());
        model.addAttribute("stockVo", stockVo1);
        return "update";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(StockVo stockVo) {
        stockVo.setUpdateTime(new Date());
        stockService.update(stockVo);
        return "redirect:/stock/getPage";
    }

    @RequestMapping("findStockName")
    public String findStockName(Model model) {
        List<StockVo> stockList = stockService.getAll();
        model.addAttribute("stockList", stockList);
        System.out.println(stockList);
        return "insert";
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(StockVo stockVo) {
        System.out.println(stockVo);
        stockVo.setCreateTime(new Date());
        stockService.add(stockVo);
        return "redirect:/stock/getPage";
    }

}
