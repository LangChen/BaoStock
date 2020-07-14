package com.chlang.common.aspect;

import com.chlang.common.annotation.ControllerWebLog;
import com.chlang.common.resp.common.PlatformHttpResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 控制层WebLog切面
 *
 * @author chenlang
 **/
@Aspect
@Component
@Order(100)
public class ControllerWebLogAspect {
    Logger logger = LoggerFactory.getLogger(ControllerWebLogAspect.class);

    private static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();

    private static final String START_TIME = "startTime";

    /**
     * 先定义切入点
     */
    //execution(<修饰符模式>?<返回类型模式><方法名模式>(<参数模式>)<异常模式>?)
    @Pointcut("execution(public * com.chlang.controller..*.*(..))")
    public void webLog(){}

    @Before(value = "webLog()&&@annotation(controllerWebLog)")
    public void doBefore(JoinPoint joinPoint, ControllerWebLog controllerWebLog){
        // 开始时间。
        long startTime = System.currentTimeMillis();
        Map<String, Object> threadInfo = new HashMap<>();
        threadInfo.put(START_TIME, startTime);

        threadLocal.set(threadInfo);
        logger.info("{}接口开始调用", controllerWebLog.apiName());
    }

    @AfterReturning(value = "webLog()&&@annotation(controllerWebLog)",returning = "resultObj")
    public void doAfterReturning(ControllerWebLog controllerWebLog, Object resultObj) throws Exception {
        Map<String, Object> threadInfo = threadLocal.get();
        long takeTime = System.currentTimeMillis() - (long) threadInfo.getOrDefault(START_TIME, System.currentTimeMillis());
        threadLocal.remove();
        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(resultObj);
        logger.info("{}接口结束调用:耗时={}ms,result={}", controllerWebLog.apiName(),
                takeTime,result);
    }

    @AfterThrowing(value = "webLog()&& @annotation(controllerWebLog)", throwing = "throwable")
    public void doAfterThrowing(ControllerWebLog controllerWebLog, Throwable throwable) {
        threadLocal.remove();
        logger.error("{}接口调用异常，异常信息{}",controllerWebLog.apiName(), throwable);
    }
}
