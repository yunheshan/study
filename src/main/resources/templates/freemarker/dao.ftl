package com.bcs.study.module.${packageName}.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bcs.study.module.${packageName}.domain.entity.${className}Entity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bcs.study.module.${packageName}.domain.form.${className}QueryForm;
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
public interface ${className}Dao extends BaseMapper<${className}Entity> {

    IPage<${className}VO> pageQuery${className}(Page<${className}VO> page, ${className}QueryForm ${lowerClassName}QueryForm);

   ${className}VO selectById(Long id);

    void batchDelete${className}(List<Long> ids);

}