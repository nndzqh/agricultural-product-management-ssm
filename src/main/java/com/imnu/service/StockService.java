package com.imnu.service;

import com.imnu.bean.vo.StockVo;

import java.util.List;

/**
 * @author WenWangXin
 * @create 2022-06-24-20:15
 */
public interface StockService {
    /**
     * 获取分页数据
     *
     * @param page
     * @param size
     * @return
     */
    List<StockVo> getPage(int page, int size);

    /**
     * 模糊查询
     * @return
     */
    List<StockVo> query(String stockName);

    void updateById(int id);

    StockVo get(Integer id);
}
