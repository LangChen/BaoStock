package com.chlang.mapper;

import com.chlang.entity.HistoryDayKData;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface HistoryDayKDataMapper extends Mapper<HistoryDayKData>, IdsMapper<HistoryDayKData>, MySqlMapper<HistoryDayKData> {
}