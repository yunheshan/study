package com.bcs.study.module.${baseInfo.packageName}.service.impl;

import com.bcs.study.module.${baseInfo.packageName}.bean.${className}Entity;
import com.bcs.study.module.${baseInfo.packageName}.mapper.${className}Mapper;
import com.bcs.study.module.${baseInfo.packageName}.service.${className}Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Desc ${tableDesc} 服务实现 接口
 * @Data
 * @Author ${baseInfo.author}
 * @Version 1.0.0
 */
@Service
public class ${className}ServiceImpl extends ServiceImpl<${className}Mapper, ${className}Entity> implements ${className}Service {

}