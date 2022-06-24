package com.imnu.service.impl;

import com.imnu.mapper.OrdersMapper;
import com.imnu.service.OrdersService;

/**
 * @author WenWangXin
 * @create 2022-06-25-1:07
 */

public class OrdersServiceImpl implements OrdersService {

    private OrdersMapper ordersMapper;

    public void setOrdersMapper(OrdersMapper ordersMapper) {
        this.ordersMapper = ordersMapper;
    }
}
