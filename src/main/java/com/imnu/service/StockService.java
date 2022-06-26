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

    StockVo get(Integer id);

    List<StockVo> getPageFind(int page, int size, String productsName);

    void update(StockVo stockVo);

    List<StockVo> getAll();

    void add(StockVo stockVo);
}
