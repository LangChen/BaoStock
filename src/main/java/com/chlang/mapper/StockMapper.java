package com.chlang.mapper;

import com.chlang.entity.Stock;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

public interface StockMapper extends Mapper<Stock>, IdsMapper<Stock>, MySqlMapper<Stock> {

    /**
     * 获取股票（指数和版块除外）
     * @return
     */
    List<Stock> getStock();

}