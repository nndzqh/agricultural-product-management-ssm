package com.imnu.mapper;

import com.imnu.bean.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 63547
* @description 针对表【orders】的数据库操作Mapper
* @createDate 2022-06-24 20:12:44
* @Entity com.imnu.bean.Orders
*/
public interface OrdersMapper {

    /**
     * 添加订单
     * @param orders 订单
     */
    void add(Orders orders);

    /**
     * 根据订单id删除订单
     * @param orderId 订单id
     */
    void delete(@Param("orderId") Integer orderId);

    /**
     * 根据订单id查询订单详细信息
     * @param orderId 订单id
     * @return orders
     */
    Orders get(@Param("orderId") Integer orderId);

    /**
     * 修改订单信息
     * @param orders 订单
     */
    void update(Orders orders);

    /**
     * 获取订单所有数据
     * @return list
     */
    List<Orders> getPage();
}
