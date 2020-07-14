package com.chlang.controller;

import com.chlang.common.annotation.ControllerWebLog;
import com.chlang.common.helper.JwtHelper;
import com.chlang.common.resp.common.ErrorCode;
import com.chlang.common.resp.common.PlatformHttpResult;
import com.chlang.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户认证接口
 *
 * @author chenlang
 * @date 2020/5/29 5:43 下午
 **/
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    /**
     * 用户登录
     * @param loginInfo
     * @return
     */
    @ControllerWebLog(apiName = "auth/login")
    @PostMapping("/login")
    public PlatformHttpResult login(@RequestBody Map<String,Object> loginInfo){
        if (!loginInfo.containsKey("userAccount") || !loginInfo.containsKey("password")){
            return PlatformHttpResult.errorWithMsg(ErrorCode.UN_KNOW_ERROR,"参数出错");
        }
        String userAccount = loginInfo.get("userAccount").toString();
        String password = loginInfo.get("password").toString();

        return authService.commonUserLogin(userAccount,password);
    }

}
