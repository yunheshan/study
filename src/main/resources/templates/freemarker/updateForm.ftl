package com.bcs.study.module.${packageName}.domain.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Author ${baseInfo.author}
 * @Date ${.now}
 * @Version 1.0.0
 * @Desc
 */
@Data
public class ${className}UpdateForm extends ${className}AddForm{

    /**
     * id
     */
    @Schema(description = "id" )
    private Long id;
}