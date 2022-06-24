package com.imnu.controller;

import com.imnu.service.StockService;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/**
 * @author WenWangXin
 * @create 2022-06-25-2:27
 */
public class StockController {

    @Resource
    @Qualifier("StockServiceImpl")
    private StockService stockService;
}
