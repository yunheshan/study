package com.bcs.study.module.${packageName}.controller;

import com.bcs.study.common.PageResultDTO;
import com.bcs.study.common.ResponseDTO;
import com.bcs.study.module.${packageName}.domain.form.${className}AddForm;
import com.bcs.study.module.${packageName}.domain.form.${className}QueryForm;
import com.bcs.study.module.${packageName}.domain.form.${className}UpdateForm;
import com.bcs.study.module.${packageName}.domain.vo.${className}VO;
import com.bcs.study.module.${packageName}.service.${className}Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Desc ${tableDesc} 前端控制器
 * @Data ${.now}
 * @Author ${baseInfo.author}
 * @Version 1.0.0
 */
@RestController
@Tag(name = "${tableDesc}控制器")
public class ${className}Controller {

    @Autowired
    private ${className}Service ${lowerClassName}Service;

    @PostMapping("/${lowerClassName}/pageQuery${className}")
    @Operation(summary = "分页查询${tableDesc}")
    public ResponseDTO<PageResultDTO<${className}VO>> pageQuery${className}(@RequestBody ${className}QueryForm ${lowerClassName}QueryForm){
        return {lowerClassName}Service.pageQuery${className}(${lowerClassName}QueryForm);
    }

    @PostMapping("/${lowerClassName}/get${className}")
    @Operation(summary = "根据ID查询${tableDesc}")
    public ResponseDTO<${className}VO> get${className}(@RequestBody Long id){
        return {lowerClassName}Service.get${className}(id);
    }

    @PostMapping("/${lowerClassName}/save${className}")
    @Operation(summary = "添加${tableDesc}")
    public ResponseDTO<String> save${className}(@RequestBody ${className}AddForm ${lowerClassName}AddForm){
        return {lowerClassName}Service.save${className}(${lowerClassName}AddForm);
    }

    @PostMapping("/${lowerClassName}/update${className}")
    @Operation(summary = "修改${tableDesc}")
    public ResponseDTO<String> update${className}(@RequestBody ${className}UpdateForm ${lowerClassName}UpdateForm){
        return {lowerClassName}Service.update${className}(${lowerClassName}UpdateForm);
    }

    @PostMapping("/${lowerClassName}/batchDelete${className}")
    @Operation(summary = "批量删除${tableDesc}(逻辑删除)")
    public ResponseDTO<String> batchDelete${className}(@RequestBody List<Long> ids){
        return {lowerClassName}Service.batchDelete${className}(ids);
    }
}