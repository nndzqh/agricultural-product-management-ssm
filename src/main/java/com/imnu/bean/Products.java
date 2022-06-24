package com.imnu.bean;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 农产品表
 * @TableName products
 */
@Data
public class Products implements Serializable {
    /**
     * 农产品id
     */
    private Integer id;

    /**
     * 分类id
     */
    private Integer categoryId;

    /**
     * 名称
     */
    private String name;

    /**
     * 图片路径
     */
    private String img;

    /**
     * 状态 0-起售，1-停售
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

    private static final long serialVersionUID = 1L;
}