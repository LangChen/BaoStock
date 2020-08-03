package com.chlang.repository;

import com.chlang.entity.UserAuth;
import com.chlang.mapper.UserAuthMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

/**
 * TODO
 *
 * @author chenlang
 * @date 2020/7/19 12:17 下午
 **/
@Repository
public class UserAuthRepository{

    @Autowired
    private UserAuthMapper userAuthMapper;

    /**
     * 根据用户账号获取用户认证信息
     * @param userAccount
     * @return
     */
    public UserAuth getByUserAccount(String userAccount){
        Example example = new Example(UserAuth.class);
        example.createCriteria().andEqualTo("userAccount",userAccount);
        return userAuthMapper.selectOneByExample(example);
    }

    /**
     * 根据用户账号获取用户认证信息
     * @param userId
     * @return
     */
    public UserAuth getByUserId(Integer userId){
        Example example = new Example(UserAuth.class);
        example.createCriteria().andEqualTo("id",userId);
        return userAuthMapper.selectOneByExample(example);
    }
}
