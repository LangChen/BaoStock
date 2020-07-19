package com.chlang.mapper;

import com.chlang.entity.Stock;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface StockMapper extends Mapper<Stock>, IdsMapper<Stock>, MySqlMapper<Stock> {
}