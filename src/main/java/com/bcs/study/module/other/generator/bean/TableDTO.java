package com.bcs.study.module.other.generator.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author bcs
 * @Date 2022/12/8 15:07
 * @Version 1.0
 * @Desc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TableDTO {

    private String tableName;

    private String className;

    private String tableComment;

    private List<ColumnDTO> columns;
}
