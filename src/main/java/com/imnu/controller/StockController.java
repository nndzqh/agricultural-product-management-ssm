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
     * @param page
     * @param size
     * @param model
     * @return
     */
    @RequestMapping(value = "getPage", method = RequestMethod.GET)
    public String getPage(@RequestParam(defaultValue = "1") int page,
                          @RequestParam(defaultValue = "5") int size,
                          Model model) {
        List<StockVo> pageList = stockService.getPage(page, size);
        PageInfo pageInfo = new PageInfo(pageList);
        model.addAttribute("pageInfo", pageInfo);
        return "pageInfo";
    }

    /**
     * 模糊查询
     * @param model
     * @return
     */
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public String query(Model model, HttpServletRequest request) {
        String stockName=request.getParameter("stockName");
        List<StockVo> stocks = stockService.query(stockName);
        model.addAttribute("stocks", stocks);
        return "";
    }

/*    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String update(Model model){

    }*/
}
