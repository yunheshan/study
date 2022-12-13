package com.bcs.study.module.${packageName}.mapper;

import com.bcs.study.module.${packageName}.bean.${className}Entity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Desc ${tableDesc} Mapper 接口
 * @Data
 * @Author ${baseInfo.author}
 * @Version 1.0.0
 */
@Mapper
public interface ${className}Mapper extends BaseMapper<${className}Entity> {

}