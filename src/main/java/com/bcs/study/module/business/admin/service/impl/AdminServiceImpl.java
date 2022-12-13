package com.bcs.study.module.business.admin.service.impl;

import com.bcs.study.module.business.admin.bean.AdminEntity;
import com.bcs.study.module.business.admin.mapper.AdminMapper;
import com.bcs.study.module.business.admin.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Desc 管理员表 服务实现 接口
 * @Data
 * @Author bcs
 * @Version 1.0.0
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, AdminEntity> implements AdminService {

}