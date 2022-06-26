package com.imnu.service.impl;

import com.github.pagehelper.PageHelper;
import com.imnu.bean.Stock;
import com.imnu.bean.VO.StockVO;
import com.imnu.mapper.StockMapper;
import com.imnu.service.StockService;

import java.util.List;

/**
 * @author WenWangXin
 * @create 2022-06-25-1:10
 */
public class StockServiceImpl implements StockService {

    private StockMapper stockMapper;

    public void setStockMapper(StockMapper stockMapper) {
        this.stockMapper = stockMapper;
    }

    /**
     * 获取分页查询全部数据
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<StockVO> getPage(int page, int size) {
        PageHelper.startPage(page, size);
        return stockMapper.getPage();
    }

    @Override
    public List<StockVO> query(String sockName) {
        return stockMapper.query(sockName);
    }
}
