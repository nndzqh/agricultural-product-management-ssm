package com.imnu.mapper;

import com.imnu.bean.vo.StockVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 63547
* @description 针对表【stock(库存表)】的数据库操作Mapper
* @createDate 2022-06-24 20:12:53
* @Entity com.imnu.bean.po.Stock
*/
public interface StockMapper {

    List<StockVo> getPage();


    StockVo get(@Param("id") Integer id);

    List<StockVo> getPageFind(String productsName);

    void update(StockVo stockVo);

    List<StockVo> getAll();

    void add(StockVo stockVo);

    /**
     * 查询是否有相同的产品
     * @param productsId 产品id
     * @return Boolean
     */
    boolean getByproductsId(@Param("productsId") Integer productsId);

    /**
     * 修改数量
     * @param  stockVo stock
     */
    void updateNum(StockVo stockVo);
}
