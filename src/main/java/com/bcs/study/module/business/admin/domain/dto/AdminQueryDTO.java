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

    /**
     * 更新时间
     */
    @Schema(description = "更新时间" )
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间" )
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createTime;

}
