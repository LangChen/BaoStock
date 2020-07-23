package com.chlang.service;

import com.chlang.common.constant.UserStatus;
import com.chlang.common.exception.PlatfromException;
import com.chlang.common.helper.JwtHelper;
import com.chlang.common.resp.common.ErrorCode;
import com.chlang.common.resp.common.PlatformHttpResult;
import com.chlang.entity.UserAuth;
import com.chlang.mapper.UserAuthMapper;
import com.chlang.reposity.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录认证
 *
 * @author chenlang
 * @date 2020/6/4 3:18 下午
 **/
@Service
public class AuthService {

    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private UserAuthRepository userAuthRepository;
    /**
     * 普通用户登录
     * @param userAccount
     * @param password
     * @return
     */
    public PlatformHttpResult commonUserLogin(String userAccount,String password){
        UserAuth userAuth = userAuthRepository.getByUserAccount(userAccount);
        if(userAuth == null){
            throw new PlatfromException(ErrorCode.AUTH_ERROR,"用户不存在");
        }
        if(userAuth.getUserStatus() != UserStatus.NORMAL.getStatus()){
            throw new PlatfromException(ErrorCode.AUTH_ERROR,"账号状态不正常");
        }

        if(!userAuth.getPassword().equals(password)){
            throw new PlatfromException(ErrorCode.AUTH_ERROR,"密码不正确");
        }

        Map<String,Object> result = new HashMap<>();
        String token = jwtHelper.createToken(userAccount);
        result.put("token",token);

        return PlatformHttpResult.successWithObj(result);
    }

}
