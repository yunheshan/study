package com.bcs.study.module.${packageName}.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bcs.study.module.${packageName}.domain.${className}DO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bcs.study.module.${packageName}.domain.dto.${className}QueryDTO;
import com.bcs.study.module.${packageName}.domain.vo.${className}VO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Desc ${tableDesc} DAO 接口
 * @Data ${.now}
 * @Author ${baseInfo.author}
 * @Version 1.0.0
 */
@Mapper
public interface ${className}Dao extends BaseMapper<${className}DO> {

    IPage<${className}VO> listPage${className}s(Page<${className}VO> page, ${className}QueryDTO ${lowerClassName}QueryDTO);

   ${className}VO selectById(Long id);

    void removeBatch${className}(List<Long> ids);

    void deleteBatch${className}(List<Long> ids);
}