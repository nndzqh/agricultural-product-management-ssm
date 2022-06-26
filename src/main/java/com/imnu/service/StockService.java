package com.imnu.service;

import com.imnu.bean.VO.StockVO;

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
    List<StockVO> getPage(int page, int size);

    /**
     * 模糊查询
     * @return
     */
    List<StockVO> query(String stockName);
}
