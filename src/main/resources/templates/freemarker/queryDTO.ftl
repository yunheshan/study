package com.bcs.study.module.${packageName}.domain.dto;

import com.bcs.study.common.PageParamDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @Desc
 * @Date ${.now}
 * @Author ${baseInfo.author}
 * @Version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ${className}QueryDTO extends PageParamDTO {

    @Schema(description = "更新时间开始" )
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDateTime updateTimeBegin;

    @Schema(description = "更新时间结束" )
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDateTime updateTimeEnd;

    @Schema(description = "创建时间开始" )
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDateTime createTimeBegin;

    @Schema(description = "创建时间结束" )
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDateTime createTimEnd;

}
