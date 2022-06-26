package com.imnu.bean.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 分类表
 * @TableName category
 */
@Data
public class Category implements Serializable {
    /**
     * 种类id
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sort;

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