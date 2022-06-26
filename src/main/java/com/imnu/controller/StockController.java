package com.imnu.controller;

import com.github.pagehelper.PageInfo;
import com.imnu.bean.vo.StockVo;
import com.imnu.service.StockService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
        /*List<StockVo> stockVoList = pageList.stream().map((item) -> {
            StockVo stockVo = new StockVo();
            BeanUtils.copyProperties(item, stockVo);
            System.out.println(item.getId());
            StockVo stockVo1 =stockService.get(item.getId());
            stockVo.setName(stockVo1.getName());
            return stockVo;
        }).collect(Collectors.toList());
        PageInfo pageInfo = new PageInfo(stockVoList);
        System.out.println(pageInfo);*/
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

//        List<StockVo> stocks = stockService.query(stockName);
//        model.addAttribute("stocks", stocks);
        return "";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(Model model, HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id")).intValue();
        stockService.updateById(id);
        return "";
    }
}
