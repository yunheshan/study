package com.bcs.study.module.${packageName}.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

<#list imports as import>
    ${import}
</#list>

/**
 * @Author ${baseInfo.author}
 * @Date ${.now}
 * @Version 1.0.0
 * @Desc
 */
@Data
public class ${className}SaveDTO {

<#list columns as column>
    <#if column.columnName!= 'id' && column.columnName!= 'create_time' && column.columnName!= 'update_time' && column.columnName!= 'is_delete'>
        /**
        * ${column.columnComment}
        */
        @Schema(description = "${column.columnName}")
        private ${column.filedType} ${column.filedName};

    </#if>
</#list>
}
