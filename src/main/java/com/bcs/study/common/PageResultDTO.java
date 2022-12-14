package com.bcs.study.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @Author bcs
 * @Date 2022/12/14 10:04
 * @Version 1.0
 * @Desc
 */
@Data
public class PageResultDTO<T> {

    /**
     * 当前页码
     */
    @Schema(description = "当前页码" )
    private Long pageIndex;

    /**
     * 每页数量
     */
    @Schema(description = "每页数量" )
    private Long pageSize;

    /**
     * 数据总数
     */
    @Schema(description = "数据总数" )
    private Long totalCount;

    /**
     * 总页数
     */
    @Schema(description = "总页数" )
    private Long totalPage;

    /**
     * 当前页结果集
     */
    @Schema(description = "当前页结果集" )
    private List<T> records;
}
