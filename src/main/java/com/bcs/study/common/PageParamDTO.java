package com.bcs.study.common;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

/**
 * @Author bcs
 * @Date 2022/12/14 10:16
 * @Version 1.0
 * @Desc
 */
@Data
public class PageParamDTO {

    /**
     * 当前页码
     */
    @Schema(description = "当前页码" )
    private Long pageIndex;

    /**
     * 每页数量
     */
    @Schema(description = "每页数量" )
    @Max(value = 200,message = "每页最大限制为200")
    private Long pageSize;

    /**
     * 需要排序的列以及对应的排序方式
     */
    @Schema(description = "需要排序的列以及对应的排序方式" )
    private List<OrderItem> orders;

}
