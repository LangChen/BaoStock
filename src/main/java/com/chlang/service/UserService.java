package com.chlang.service;

import com.chlang.common.resp.bean.UserInfo;
import com.chlang.common.resp.common.PlatformHttpResult;
import com.chlang.entity.UserAuth;
import com.chlang.repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author chenlang
 * @date 2020/7/29 11:23 上午
 **/
@Service
public class UserService {

    @Autowired
    private UserAuthRepository userAuthRepository;

    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    public PlatformHttpResult getUserInfo(Integer userId){
        UserAuth userAuth = userAuthRepository.getByUserId(userId);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setUserAccount(userAuth.getUserAccount());
        return PlatformHttpResult.successWithObj(userInfo);
    }
}
