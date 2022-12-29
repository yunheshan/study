package com.bcs.study.module.${packageName}.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bcs.study.common.PageResultDTO;
import com.bcs.study.common.ResponseDTO;
import com.bcs.study.module.${packageName}.domain.entity.${className}Entity;
import com.bcs.study.module.${packageName}.dao.${className}Dao;
import com.bcs.study.module.${packageName}.domain.form.${className}AddForm;
import com.bcs.study.module.${packageName}.domain.form.${className}QueryForm;
import com.bcs.study.module.${packageName}.domain.form.${className}UpdateForm;
import com.bcs.study.module.${packageName}.domain.vo.${className}VO;
import com.bcs.study.module.${packageName}.service.${className}Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bcs.study.util.PackedBeanUtils;
import com.bcs.study.util.PageUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Desc ${tableDesc} 服务接口实现类
 * @Data ${.now}
 * @Author ${baseInfo.author}
 * @Version 1.0.0
 */
@Service
public class ${className}ServiceImpl extends ServiceImpl<${className}Dao, ${className}DO> implements ${className}Service {

    @Override
    public ResponseDTO<PageResultDTO<${className}VO>> pageQuery${className}(${className}QueryForm ${lowerClassName}QueryForm) {
        Page<${className}VO> ${lowerClassName}VOPage = PageUtils.convert2QueryPage(${lowerClassName}QueryForm);
        IPage<${className}VO> ${lowerClassName}VOIPage = baseMapper.pageQuery${className}(${lowerClassName}VOPage, ${lowerClassName}QueryForm);
        PageResultDTO<${className}VO> ${lowerClassName}VOPageResultDTO = PageUtils.convert2PageResult(${lowerClassName}VOIPage);
        return ResponseDTO.successData(${lowerClassName}VOPageResultDTO);
    }

    @Override
    public ResponseDTO<String> save${className}(${className}AddForm ${lowerClassName}AddForm) {
        ${className}DO ${lowerClassName}DO = PackedBeanUtils.copy2Class(${lowerClassName}AddForm, ${className}DO.class);
        baseMapper.insert(${lowerClassName}DO);
        return ResponseDTO.success();
    }

    @Override
    public ResponseDTO<String> update${className}(${className}UpdateForm ${lowerClassName}UpdateForm) {
        ${className}DO ${lowerClassName}DO = PackedBeanUtils.copy2Class(${lowerClassName}UpdateForm, ${className}DO.class);
        baseMapper.updateById(${lowerClassName}DO);
        return ResponseDTO.success();
    }

    @Override
    public ResponseDTO<String> batchDelete${className}(List<Long> ids) {
        baseMapper.batchDelete${className}(ids);
        return ResponseDTO.success();
    }

    @Override
    public ResponseDTO<${className}VO> get${className}(Long id) {
        ${className}VO ${lowerClassName}VO = baseMapper.selectById(id);
        return ResponseDTO.successData(${lowerClassName}VO);
    }

}