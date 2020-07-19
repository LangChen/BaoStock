package com.chlang.common.constant;

/**
 * 用户状态
 *
 * @author chenlang
 * @date 2020/7/19 12:27 下午
 **/
public enum UserStatus {
    /**
     * 正常
     */
    NORMAL((byte)0);

    private Byte status;

    private UserStatus(Byte status){
        this.status = status;
    }

    public Byte getStatus(){
        return this.status;
    }

}
