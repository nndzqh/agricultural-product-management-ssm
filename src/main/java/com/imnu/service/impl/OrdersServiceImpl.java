package com.imnu.service.impl;

import com.github.pagehelper.PageHelper;
import com.imnu.bean.po.Orders;
import com.imnu.mapper.OrdersMapper;
import com.imnu.service.OrdersService;

import java.util.List;

/**
 * @author WenWangXin
 * @create 2022-06-25-1:07
 */

public class OrdersServiceImpl implements OrdersService {

    private OrdersMapper ordersMapper;

    public void setOrdersMapper(OrdersMapper ordersMapper) {
        this.ordersMapper = ordersMapper;
    }

    @Override
    public void add(Orders orders) {
        ordersMapper.add(orders);
    }

    @Override
    public void delete(Integer orderId) {
        ordersMapper.delete(orderId);
    }

    @Override
    public Orders get(Integer orderId) {
        return ordersMapper.get(orderId);
    }

    @Override
    public void update(Orders orders) {
        ordersMapper.update(orders);
    }

    @Override
    public List<Orders> getPage(int page, int size) {
        PageHelper.startPage(page,size);
        return ordersMapper.getPage();
    }
}
