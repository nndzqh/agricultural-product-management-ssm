package com.imnu.bean.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName orders
 */
@Data
public class Orders implements Serializable {
    /**
     * 订单id
     */
    private Integer id;

    /**
     * 订单号
     */
    private String number;

    /**
     * 产品id
     */
    private Integer productsId;

    /**
     * 数量
     */
    private Integer num;

    /**
     * 地址
     */
    private String address;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 状态 0-已支付，1-未支付，2-已发货，3-未发货，4-已签收，5-未签收
     */
    private Integer state;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 订单完成时间
     */
    private Date endTime;

    private static final long serialVersionUID = 1L;
}