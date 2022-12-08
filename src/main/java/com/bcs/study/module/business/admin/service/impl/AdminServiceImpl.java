package com.bcs.study.module.business.admin.service.impl;

import com.bcs.study.module.business.admin.bean.Admin;
import com.bcs.study.module.business.admin.mapper.AdminMapper;
import com.bcs.study.module.business.admin.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author bcs
 * @since 2022-12-07
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

}
