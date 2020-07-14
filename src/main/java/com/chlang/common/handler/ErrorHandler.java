package com.chlang.common.handler;

import com.chlang.common.exception.PlatfromException;
import com.chlang.common.resp.common.ErrorCode;
import com.chlang.common.resp.common.PlatformHttpResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 全局异常捕获处理
 */
@ControllerAdvice
public class ErrorHandler {
    private Logger logger = LoggerFactory.getLogger(ErrorCode.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PlatformHttpResult exceptionHandler(Exception e) {
        logger.error("未知异常，e:"+e.getMessage());
        e.printStackTrace();
        return PlatformHttpResult.errorWithMsg(ErrorCode.UN_KNOW_ERROR,e.getMessage());
    }

    @ExceptionHandler(PlatfromException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PlatformHttpResult exceptionHandler(PlatfromException e) {
        logger.error("平台自定义异常，errorCode:"+e.getErrorCode()+" errorMsg:"+e.getErrorMsg());
        e.printStackTrace();
        return PlatformHttpResult.errorWithMsg(e.getErrorCode(),e.getErrorMsg());
    }

}
