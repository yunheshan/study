package com.bcs.study.module.${packageName}.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Tag(name = "${ClassName}VO", description = "${tableDesc}VO对象" )
public class ${ClassName}VO {

<#list columns as column>
    <#if column.columnName!= 'create_time' && column.columnName!= 'update_time'>
        /**
         * ${column.columnComment}
         */
        @Schema("${column.columnName}")
        private ${column.filedType} ${column.filedName};

    </#if>
    <#if column.columnName= 'create_time' || column.columnName= 'update_time'>
        /**
         * ${column.columnComment}
         */
        @Schema("${column.columnName}")
        @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
        private ${column.filedType} ${column.filedName};
    </#if>
</#list>

}
