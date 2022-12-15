package com.bcs.study.module.${packageName}.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Author ${baseInfo.author}
 * @Date ${.now}
 * @Version 1.0.0
 * @Desc
 */
@Data
public class ${className}UpdateDTO extends ${className}SaveDTO{

    /**
     * id
     */
    @Schema(description = "id" )
    private Long id;
}