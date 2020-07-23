package com.chlang.service;

import com.chlang.common.resp.bean.KData;
import com.chlang.common.resp.common.PlatformHttpResult;
import com.chlang.mapper.HistoryDayKDataMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * K线业务处理类
 *
 * @author chenlang
 * @date 2020/7/19 12:42 下午
 **/
@Service
public class HistoryDayKDataService {

    @Autowired
    private HistoryDayKDataMapper historyDayKDataMapper;

    /**
     * 获取k线数据
     * @param code
     * @return
     */
    public PlatformHttpResult getHistoryDayKData(String code,Integer pageNum,
                                                 Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<KData> kDataList = historyDayKDataMapper.getKDataByCode(code);
        PageInfo<KData> pageInfo = new PageInfo<>(kDataList);
        kDataList = pageInfo.getList();

        Map<String,Object> result = new HashMap<>();
        result.put("total",pageInfo.getTotal());
        result.put("list",kDataList);

        return PlatformHttpResult.successWithObj(result);
    }

    /**
     * 获取最新一天的k线数据
     * @param code
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PlatformHttpResult getLastHistoryDayKData(String code,Integer pageNum,Integer pageSize){
        Map<String,Object> result = new HashMap<>();

        String lastDate = historyDayKDataMapper.getLastDay();
        if(lastDate == null){
            result.put("total",0);
            result.put("list", Collections.EMPTY_LIST);
            return PlatformHttpResult.successWithObj(result);
        }
        PageHelper.startPage(pageNum,pageSize);
        List<KData> kDataList = historyDayKDataMapper.getKData(code,lastDate);
        PageInfo<KData> pageInfo = new PageInfo<>(kDataList);
        kDataList = pageInfo.getList();

        result.put("total",pageInfo.getTotal());
        result.put("list",kDataList);

        return PlatformHttpResult.successWithObj(result);
    }

}
