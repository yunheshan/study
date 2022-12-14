package com.bcs.study.module.${packageName}.service.impl;

import com.bcs.study.module.${packageName}.domain.${className}DO;
import com.bcs.study.module.${packageName}.dao.${className}Dao;
import com.bcs.study.module.${packageName}.service.${className}Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Desc ${tableDesc} 服务接口实现类
 * @Data ${.now}
 * @Author ${baseInfo.author}
 * @Version 1.0.0
 */
@Service
public class ${className}ServiceImpl extends ServiceImpl<${className}Dao, ${className}DO> implements ${className}Service {

}