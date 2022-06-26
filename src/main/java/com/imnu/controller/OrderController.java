package com.imnu.controller;

import com.github.pagehelper.PageInfo;
import com.imnu.bean.po.Orders;
import com.imnu.bean.po.Products;
import com.imnu.bean.vo.OrdersVo;
import com.imnu.service.OrdersService;
import com.imnu.service.ProductsService;
import org.springframework.beans.BeanUtils;
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
import java.util.stream.Collectors;

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

    @Resource
    @Qualifier("ProductsServiceImpl")
    private ProductsService productsService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Orders orders){
        String number = UUID.randomUUID().toString().replaceAll("-", "");
        orders.setNumber(number);
        ordersService.add(orders);
        return "";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String delete(Integer ordersId){
        ordersService.delete(ordersId);
        System.out.println(ordersId);
        return "redirect:/orders/getPage";
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
                          @RequestParam(defaultValue = "5")int size, Model model, String keyWord){
        List<Orders> pageList = ordersService.getPage(page,size,keyWord);
       // System.out.println("EEEEEEEEEEEEE"+keyWord);
        List<OrdersVo> ordersVoList = pageList.stream().map((item) ->{
            OrdersVo ordersVo = new OrdersVo();
            BeanUtils.copyProperties(item, ordersVo);
            Products products = productsService.get(item.getProductsId());
            ordersVo.setProductName(products.getName());
            return ordersVo;
        }).collect(Collectors.toList());
        PageInfo<OrdersVo> pageInfo = new PageInfo<>(ordersVoList);
        model.addAttribute("pageInfo",pageInfo);
        return "order";
    }
}
