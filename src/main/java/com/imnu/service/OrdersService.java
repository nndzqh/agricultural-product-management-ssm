package com.imnu.service;

import com.imnu.bean.po.Orders;

import java.util.List;

/**
 * @author WenWangXin
 * @create 2022-06-24-20:16
 */
public interface OrdersService {

    /**
     * 添加订单
     * @param orders 订单
     */
    void add(Orders orders);

    /**
     * 删除订单
     * @param orderId 订单id
     */
    void delete(Integer orderId);

    /**
     * 根据订单id获取订单信息
     * @param orderId 订单id
     * @return orders
     */
    Orders get(Integer orderId);

    /**
     * 修改订单信息
     * @param orders 订单
     */
    void update(Orders orders);

    /**
     * 分页获取所有订单数据
     * @param page 第几页
     * @param size 显示条数
     * @return list
     */
    List<Orders> getPage(int page, int size,String keyWord);
}
