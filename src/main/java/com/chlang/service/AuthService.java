package com.chlang.service;

import com.chlang.common.helper.JwtHelper;
import com.chlang.common.resp.common.PlatformHttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author chenlang
 * @date 2020/6/4 3:18 下午
 **/
@Service
public class AuthService {

    @Autowired
    private JwtHelper jwtHelper;

    /**
     * 普通用户登录
     * @param userAccount
     * @param password
     * @return
     */
    public PlatformHttpResult commonUserLogin(String userAccount,String password){

        //TODO 验证账号密码

        Map<String,Object> result = new HashMap<>();
        String token = jwtHelper.createToken(userAccount);
        result.put("token",token);

        return PlatformHttpResult.successWithObj(result);
    }

}
