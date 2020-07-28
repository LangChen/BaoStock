package com.chlang.repository;

import com.chlang.entity.HistoryDayKData;
import com.chlang.mapper.HistoryDayKDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * TODO
 *
 * @author chenlang
 * @date 2020/7/24 4:36 下午
 **/
@Repository
public class KDataRepository {

    @Autowired
    private HistoryDayKDataMapper historyDayKDataMapper;

    /**
     * 获取某个股票的某段时间的k线
     * @param code
     * @param dates
     * @return
     */
    public List<HistoryDayKData> getHistoryDayKDataByCode(String code,
                                                   List<String> dates){
        Example example = new Example(HistoryDayKData.class);
        example.createCriteria().andEqualTo("code",code)
                .andIn("date",dates);
        example.setOrderByClause("date asc");
        return historyDayKDataMapper.selectByExample(example);
    }

}
