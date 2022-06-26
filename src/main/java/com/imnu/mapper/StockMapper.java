package com.imnu.mapper;

import com.imnu.bean.vo.StockVo;

import java.util.List;

/**
* @author 63547
* @description 针对表【stock(库存表)】的数据库操作Mapper
* @createDate 2022-06-24 20:12:53
* @Entity com.imnu.bean.po.Stock
*/
public interface StockMapper {

    List<StockVo> getPage();

    List<StockVo> query(String sockName);
}
