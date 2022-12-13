package com.bcs.study.module.${packageName}.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

<#list imports as import>
${import}
</#list>

import com.bcs.study.common.bean.BaseEntity;
import lombok.*;

/**
 * @Desc ${tableDesc}
 * @Date
 * @Author ${baseInfo.author}
 * @Version 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("${tableName}")
public class ${className}Entity extends BaseEntity {

<#list columns as column>
    <#if column.columnName!= 'id' && column.columnName!= 'create_time' && column.columnName!= 'update_time' && column.columnName!= 'is_delete'>
    /**
     * ${column.columnComment}
     */
    @TableField("${column.columnName}")
    private ${column.filedType} ${column.filedName};

    </#if>
</#list>
}