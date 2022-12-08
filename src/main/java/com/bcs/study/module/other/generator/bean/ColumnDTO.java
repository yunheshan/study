package com.bcs.study.module.other.generator.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author bcs
 * @Date 2022/12/8 15:05
 * @Version 1.0
 * @Desc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ColumnDTO {

    private String columnName;

    private String columnType;

    private String columnComment;

    private String columnDefault;

    private String orderNo;
}
