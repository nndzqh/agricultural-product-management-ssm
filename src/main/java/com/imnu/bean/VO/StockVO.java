package com.imnu.bean.VO;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 库存显示表
 *
 */
@Data
public class StockVO implements Serializable {
    /**
     * 库存id
     */
    private Integer id;

    /**
     * 库存名称
     */
    private String name;

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