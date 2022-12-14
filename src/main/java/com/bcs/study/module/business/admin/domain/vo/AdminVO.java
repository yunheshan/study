package com.bcs.study.module.business.admin.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author bcs
 * @Date 2022/12/14 10:27
 * @Version 1.0
 * @Desc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Tag(name = "AdminVO", description = "管理员VO对象" )
public class AdminVO {

    /**
     * id
     */
    @Schema(description = "id" )
    private Long id;


    /**
     * 用户名
     */
    @Schema(description = "用户名" )
    private String name;

    /**
     * 密码
     */
    @Schema(description = "密码" )
    private String password;

    /**
     * 账户余额
     */
    @Schema(description = "账户余额" )
    private BigDecimal amount;

    /**
     * 状态(0 默认 ...)
     */
    @Schema(description = "状态" )
    private Integer status;


    /**
     * 更新时间
     */
    @Schema(description = "更新时间" )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间" )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 逻辑删除
     */
    @Schema(description = "逻辑删除" )
    private Integer isDeleted;
}
