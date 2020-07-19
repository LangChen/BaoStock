package com.chlang.mapper;

import com.chlang.entity.UserAuth;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface UserAuthMapper extends Mapper<UserAuth>, IdsMapper<UserAuth>, MySqlMapper<UserAuth> {

}