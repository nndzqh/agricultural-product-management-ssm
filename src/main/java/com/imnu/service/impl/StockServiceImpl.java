package com.imnu.service.impl;

import com.github.pagehelper.PageHelper;
import com.imnu.bean.vo.StockVo;
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
    public List<StockVo> getPage(int page, int size) {
        PageHelper.startPage(page, size);
        return stockMapper.getPage();
    }



    @Override
    public StockVo get(Integer id) {
        return stockMapper.get(id);
    }

    @Override
    public List<StockVo> getPageFind(int page, int size, String productsName) {
        PageHelper.startPage(page, size);
        return stockMapper.getPageFind(productsName);
    }

    @Override
    public void update(StockVo stockVo) {
        stockMapper.update(stockVo);
    }

    @Override
    public List<StockVo> getAll() {
        return stockMapper.getAll();
    }

    @Override
    public void add(StockVo stockVo) {
        stockMapper.add(stockVo);
    }

    @Override
    public boolean getByproductsId(Integer productsId) {
        return stockMapper.getByproductsId(productsId);
    }

    @Override
    public void updateNum(StockVo stockVo) {
        stockMapper.updateNum(stockVo);
    }

}
