package com.bcs.study.module.${packageName}.service;

import com.bcs.study.common.PageResultDTO;
import com.bcs.study.common.ResponseDTO;
import com.bcs.study.module.${packageName}.domain.entity.${className}Entity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bcs.study.module.${packageName}.domain.form.${className}AddForm;
import com.bcs.study.module.${packageName}.domain.form.${className}QueryForm;
import com.bcs.study.module.${packageName}.domain.form.${className}UpdateForm;
import com.bcs.study.module.${packageName}.domain.vo.${className}VO;

import java.util.List;

/**
 * @Desc ${tableDesc} 服务接口
 * @Data ${.now}
 * @Author ${baseInfo.author}
 * @Version 1.0.0
 */
public interface ${className}Service extends IService<${className}Entity> {

    /**
    * 分页查询
    * @param ${lowerClassName}QueryForm
    * @return
    */
    ResponseDTO<PageResultDTO<${className}VO>> pageQuery${className}(${className}QueryForm ${lowerClassName}QueryForm);

    /**
    * 根据ID查询
    * @param id
    * @return
    */
    ResponseDTO<${className}VO> get${className}(Long id);

    /**
    * 新增
    * @param ${lowerClassName}AddForm
    * @return
    */
    ResponseDTO<String> save${className}(${className}AddForm ${lowerClassName}AddForm);

    /**
    * 更改
    * @param ${lowerClassName}QueryForm
    * @return
    */
    ResponseDTO<String> update${className}(${className}QueryForm ${lowerClassName}QueryForm);

    /**
    * 批量删除(逻辑删除)
    * @param ids
    * @return
    */
    ResponseDTO<String> batchDelete${className}(List<Long> ids);
}