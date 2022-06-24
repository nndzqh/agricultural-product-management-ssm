package com.imnu.controller;

import com.imnu.service.OrdersService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author WenWangXin
 * @create 2022-06-25-2:25
 */
@Controller
public class OrderController {

    @Resource
    @Qualifier("OrdersServiceImpl")
    private OrdersService ordersService;


}
