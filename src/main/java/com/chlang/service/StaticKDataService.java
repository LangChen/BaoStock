package com.chlang.service;

import com.chlang.common.resp.bean.StockInfo;
import com.chlang.entity.HistoryDayKData;
import com.chlang.entity.Stock;
import com.chlang.mapper.HistoryDayKDataMapper;
import com.chlang.mapper.StockMapper;
import com.chlang.repository.KDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * TODO
 *
 * @author chenlang
 * @date 2020/7/24 4:57 下午
 **/
@Service
public class StaticKDataService {

    @Autowired
    private HistoryDayKDataMapper historyDayKDataMapper;
    @Autowired
    private StockMapper stockMapper;
    @Autowired
    private KDataRepository kDataRepository;

    /**
     * 查找最近4天，前3天是跌，最后一天不跌的股票
     * @return
     */
    public List<StockInfo> static1(String date){
        if(date == null){
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MMM-dd");
            date = sd.format(new Date());
        }
        List<String> days = historyDayKDataMapper.getLastDayByCount(date,4);
        List<Stock> allStock = stockMapper.getStock();
        System.out.println(days.toString());
        System.out.println(allStock.size());

        List<StockInfo> stockInfos = new ArrayList<>();
        for(Stock stock : allStock){
            List<HistoryDayKData> historyDayKDatas = kDataRepository.getHistoryDayKDataByCode(stock.getCode(),days);
            if(historyDayKDatas.size() != 4){
                continue;
            }
            HistoryDayKData kDataBefore3 = historyDayKDatas.get(0);
            HistoryDayKData kDataBefore2 = historyDayKDatas.get(1);
            HistoryDayKData kDataBefore1 = historyDayKDatas.get(2);
            HistoryDayKData today = historyDayKDatas.get(3);
            if(kDataBefore3.getOpen() != null && kDataBefore3.getClose() != null){
                if (kDataBefore3.getOpen().intValue() - kDataBefore3.getClose().intValue() <= 0){
                    continue;
                }
            }
            if(kDataBefore2.getOpen() != null && kDataBefore2.getClose() != null){
                if (kDataBefore2.getOpen().intValue() - kDataBefore2.getClose().intValue() <= 0){
                    continue;
                }
            }
            if(kDataBefore1.getOpen() != null && kDataBefore1.getClose() != null){
                if (kDataBefore1.getOpen().intValue() - kDataBefore1.getClose().intValue() <= 0){
                    continue;
                }
            }
            if(today.getOpen() != null && today.getClose() != null){
                if (today.getOpen().intValue() - today.getClose().intValue() >= 0){
                    continue;
                }
            }

            StockInfo stockInfo = new StockInfo();
            stockInfo.setCode(stock.getCode());
            stockInfo.setName(stock.getCodeName());

            stockInfos.add(stockInfo);
        }

        return stockInfos;
    }

}
