package com.bcs.study.module.business.user.service.impl;

import com.bcs.study.module.business.user.bean.UserEntity;
import com.bcs.study.module.business.user.mapper.UserMapper;
import com.bcs.study.module.business.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Desc 用户表 服务实现 接口
 * @Data
 * @Author bcs
 * @Version 1.0.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

}