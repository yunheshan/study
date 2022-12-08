package com.bcs.study.module.user.service.impl;

import com.bcs.study.module.user.bean.User;
import com.bcs.study.module.user.mapper.UserMapper;
import com.bcs.study.module.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bcs
 * @since 2022-12-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
