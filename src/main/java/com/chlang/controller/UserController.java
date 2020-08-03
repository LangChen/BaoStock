package com.chlang.controller;

import com.chlang.common.annotation.ControllerWebLog;
import com.chlang.common.constant.CommonConstants;
import com.chlang.common.resp.common.PlatformHttpResult;
import com.chlang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * TODO
 *
 * @author chenlang
 * @date 2020/7/29 11:21 上午
 **/
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户信息
     * @param httpServletRequest
     * @return
     */
    @ControllerWebLog(apiName = "/user/me")
    @GetMapping("/me")
    public PlatformHttpResult getUserInfo(HttpServletRequest httpServletRequest){
        Integer userId = Integer.valueOf(httpServletRequest.getAttribute(CommonConstants.CURRENT_USER_ID).toString());
        return userService.getUserInfo(userId);
    }

}
