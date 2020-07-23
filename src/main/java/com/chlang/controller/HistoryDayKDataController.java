package com.chlang.controller;

import com.chlang.common.annotation.ControllerWebLog;
import com.chlang.common.resp.common.PlatformHttpResult;
import com.chlang.service.HistoryDayKDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * K线API
 *
 * @author chenlang
 * @date 2020/7/19 12:45 下午
 **/
@RestController
@RequestMapping("/api/v1/historyDayKData")
public class HistoryDayKDataController {

    @Autowired
    private HistoryDayKDataService historyDayKDataService;

    /**
     * 获取k线数据
     * @return
     */
    @ControllerWebLog(apiName = "/historyDayKData")
    @GetMapping("")
    public PlatformHttpResult getHistoryDayKData(@RequestParam(value = "code",required = false)String code,
                                                 @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                                                 @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize){

        return historyDayKDataService.getHistoryDayKData(code,pageNum,pageSize);
    }

    /**
     * 获取最新的k线数据
     * @return
     */
    @ControllerWebLog(apiName = "/historyDayKData")
    @GetMapping("/last")
    public PlatformHttpResult getLastHistoryDayKData(@RequestParam(value = "code",required = false)String code,
                                                 @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                                                 @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize){

        return historyDayKDataService.getLastHistoryDayKData(code,pageNum,pageSize);
    }
}
