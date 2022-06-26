package com.imnu.controller;

import com.imnu.bean.po.Orders;
import com.imnu.service.OrdersService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * @author WenWangXin
 * @create 2022-06-25-2:25
 */

@Controller
@RequestMapping("orders")
public class OrderController {

    @Resource
    @Qualifier("OrdersServiceImpl")
    private OrdersService ordersService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Orders orders){
        String number = UUID.randomUUID().toString().replaceAll("-", "");
        orders.setNumber(number);
        ordersService.add(orders);
        return "";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String delete(Integer orderId){
        ordersService.delete(orderId);
        return "";
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public String get(Integer orderId, Model model){
        Orders orders = ordersService.get(orderId);
        if (!Objects.isNull(orders)){
            model.addAttribute("orders",orders);
            return "";
        }
        return "";
    }
    
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(Orders orders){
        ordersService.update(orders);
        return "";
    }

    @RequestMapping(value = "getPage", method = RequestMethod.GET)
    public String getPage(@RequestParam(defaultValue = "1") int page,
                          @RequestParam(defaultValue = "10")int size, Model model){
        List<Orders> ordersList = ordersService.getPage(page,size);
        model.addAttribute("ordersList",ordersList);
        return "";
    }
}
