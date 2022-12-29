package com.bcs.study.module.business.admin.domain.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author bcs
 * @Date 2022/12/14 11:25
 * @Version 1.0
 * @Desc
 */
@Data
public class AdminAddForm {

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
}
