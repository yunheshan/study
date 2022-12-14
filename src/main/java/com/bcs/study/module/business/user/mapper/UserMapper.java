package com.bcs.study.module.business.user.mapper;

import com.bcs.study.module.business.user.bean.UserDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Desc 用户表 Mapper 接口
 * @Data
 * @Author bcs
 * @Version 1.0.0
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {

}