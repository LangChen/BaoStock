package com.chlang.common.resp.bean;

/**
 * TODO
 *
 * @author chenlang
 * @date 2020/7/29 11:45 上午
 **/
public class UserInfo {

    private Integer userId;

    private String userAccount;

    private String userName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
