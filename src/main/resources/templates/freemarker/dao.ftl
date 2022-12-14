package com.bcs.study.module.${packageName}.dao;

import com.bcs.study.module.${packageName}.domain.${className}DO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Desc ${tableDesc} DAO 接口
 * @Data ${.now}
 * @Author ${baseInfo.author}
 * @Version 1.0.0
 */
@Mapper
public interface ${className}Dao extends BaseMapper<${className}DO> {

}