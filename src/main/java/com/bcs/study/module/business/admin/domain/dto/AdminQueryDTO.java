package com.bcs.study.module.business.admin.domain.dto;

import com.bcs.study.common.PageParamDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @Author bcs
 * @Date 2022/12/14 10:12
 * @Version 1.0
 * @Desc
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AdminQueryDTO extends PageParamDTO {

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
    private LocalDateTime createTimeEnd;

}
