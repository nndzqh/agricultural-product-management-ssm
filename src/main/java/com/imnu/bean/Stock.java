package com.imnu.bean;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 库存表
 * @TableName stock
 */
@Data
public class Stock implements Serializable {
    /**
     * 库存id
     */
    private Integer id;

    /**
     * 产品id
     */
    private Integer products;

    /**
     * 数量
     */
    private Integer sum;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}