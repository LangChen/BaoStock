package com.chlang.mapper;

import com.chlang.common.resp.bean.KData;
import com.chlang.entity.HistoryDayKData;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

public interface HistoryDayKDataMapper extends Mapper<HistoryDayKData>, IdsMapper<HistoryDayKData>, MySqlMapper<HistoryDayKData> {

    /**
     * 获取某个股票的k线数据
     * @param code
     * @return
     */
    List<KData> getKDataByCode(@Param("code")String code);

    /**
     * 获取某个股票的k线数据
     * @param code
     * @return
     */
    List<KData> getKData(@Param("code")String code,@Param("date")String date);

    String getLastDay();

}