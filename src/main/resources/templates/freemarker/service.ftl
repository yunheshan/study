package com.bcs.study.module.${packageName}.service;

import com.bcs.study.common.PageResultDTO;
import com.bcs.study.common.ResponseDTO;
import com.bcs.study.module.${packageName}.domain.${className}DO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bcs.study.module.${packageName}.domain.dto.${className}SaveDTO;
import com.bcs.study.module.${packageName}.domain.dto.${className}QueryDTO;
import com.bcs.study.module.${packageName}.domain.dto.${className}UpdateDTO;
import com.bcs.study.module.${packageName}.domain.vo.${className}VO;

import java.util.List;

/**
 * @Desc ${tableDesc} 服务接口
 * @Data ${.now}
 * @Author ${baseInfo.author}
 * @Version 1.0.0
 */
public interface I${className}Service extends IService<${className}DO> {

    /**
    * 分页查询
    * @param ${lowerClassName}QueryDTO
    * @return
    */
    ResponseDTO<PageResultDTO<${className}VO>> listPage${className}s(${className}QueryDTO ${lowerClassName}QueryDTO);

    /**
    * 根据ID查询
    * @param id
    * @return
    */
    ResponseDTO<${className}VO> get${className}(Long id);

    /**
    * 新增
    * @param ${lowerClassName}SaveDTO
    * @return
    */
    ResponseDTO<String> save${className}(${className}SaveDTO ${lowerClassName}SaveDTO);

    /**
    * 更改
    * @param ${lowerClassName}UpdateDTO
    * @return
    */
    ResponseDTO<String> update${className}(${className}UpdateDTO ${lowerClassName}UpdateDTO);

    /**
    * 批量删除(逻辑删除)
    * @param ids
    * @return
    */
    ResponseDTO<String> removeBatch${className}(List<Long> ids);

    /**
    * 批量删除(物理删除)
    * @param ids
    * @return
    */
    ResponseDTO<String> deleteBatch${className}(List<Long> ids);
}