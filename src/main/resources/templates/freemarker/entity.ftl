package com.bcs.study.module.${baseInfo.packageName}.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.bcs.study.common.bean.BaseEntity;
import lombok.*;

/**
*
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
public class ${className} extends BaseEntity{

<#list columns as column>
    <#if column.columnName!= 'id' && column.columnName!= 'create_time' && column.columnName!= 'update_time' >
        /**
        * ${column.columnComment}
        */
        @TableField("${column.columnName}")
        private ${column.filedType} ${column.filedName};

    </#if>
</#list>
}