package com.bcs.study.module.${packageName}.controller;

import com.bcs.study.common.PageResultDTO;
import com.bcs.study.common.ResponseDTO;
import com.bcs.study.module.${packageName}.domain.dto.${className}SaveDTO;
import com.bcs.study.module.${packageName}.domain.dto.${className}QueryDTO;
import com.bcs.study.module.${packageName}.domain.dto.${className}UpdateDTO;
import com.bcs.study.module.${packageName}.domain.vo.${className}VO;
import com.bcs.study.module.${packageName}.service.I${className}Service;
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
@RequestMapping("/${lowerClassName}")
@Tag(name = "${tableDesc}控制器")
public class ${className}Controller {

    @Autowired
    private I${className}Service i${className}Service;

    @PostMapping("/listPage${className}s")
    @Operation(summary = "分页查询${tableDesc}")
    public ResponseDTO<PageResultDTO<${className}VO>> listPage${className}s(@RequestBody ${className}QueryDTO ${lowerClassName}QueryDTO){
        return i${className}Service.listPage${className}s(${lowerClassName}QueryDTO);
    }

    @PostMapping("/get${className}")
    @Operation(summary = "根据ID查询${tableDesc}")
    public ResponseDTO<${className}VO> get${className}(@RequestBody Long id){
        return i${className}Service.get${className}(id);
    }

    @PostMapping("/save${className}")
    @Operation(summary = "添加${tableDesc}")
    public ResponseDTO<String> save${className}(@RequestBody ${className}SaveDTO ${lowerClassName}SaveDTO){
        return i${className}Service.save${className}(${lowerClassName}SaveDTO);
    }

    @PostMapping("/update${className}")
    @Operation(summary = "修改${tableDesc}")
    public ResponseDTO<String> update${className}(@RequestBody ${className}UpdateDTO ${lowerClassName}UpdateDTO){
        return i${className}Service.update${className}(${lowerClassName}UpdateDTO);
    }

    @PostMapping("/removeBatch${className}")
    @Operation(summary = "批量删除${tableDesc}(逻辑删除)")
    public ResponseDTO<String> removeBatch${className}(@RequestBody List<Long> ids){
        return i${className}Service.removeBatch${className}(ids);
    }

    @PostMapping("/deleteBatch${className}")
    @Operation(summary = "批量删除${tableDesc}(物理删除)")
    public ResponseDTO<String> deleteBatch${className}(@RequestBody List<Long> ids){
        return i${className}Service.deleteBatch${className}(ids);
    }
}