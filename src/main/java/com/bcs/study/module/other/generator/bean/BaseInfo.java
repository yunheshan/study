package com.bcs.study.module.other.generator.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author bcs
 * @Date 2022/12/8 16:34
 * @Version 1.0
 * @Desc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseInfo {

    private String author;

    private List<String> tableNames;

    private String packageName;

    private String tablePrefix;
}
