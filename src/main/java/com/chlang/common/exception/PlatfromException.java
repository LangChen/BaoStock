package com.chlang.common.exception;

/**
 * 平台自定义异常
 */
public class PlatfromException extends RuntimeException{

    /**
     * 错误码，在ErrorCode定义
     */
    private Integer errorCode;
    /**
     * 出错信息
     */
    private String errorMsg;

    /**
     * 自定义异常
     * @param errorCode com.chlang.common.response.ErrorCode 定义
     * @param errorMsg
     */
    public PlatfromException(Integer errorCode,String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
