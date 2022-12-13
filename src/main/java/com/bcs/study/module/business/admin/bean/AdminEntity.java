package com.bcs.study.module.business.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;

import com.bcs.study.common.bean.BaseEntity;
import lombok.*;

/**
 * @Desc 管理员表
 * @Date
 * @Author bcs
 * @Version 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_admin")
public class AdminEntity extends BaseEntity {

    /**
     * 用户名
     */
    @TableField("name")
    private String name;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 账户余额
     */
    @TableField("amount")
    private BigDecimal amount;

    /**
     * 状态(0 默认 ...)
     */
    @TableField("status")
    private Integer status;

}