package com.bcs.study.module.business.user.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;

import com.bcs.study.common.bean.BaseEntity;
import lombok.*;

/**
 * @Desc 
 * @Date
 * @Author bcs
 * @Version 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_user")
public class UserEntity extends BaseEntity {

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
     * 昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 手机号
     */
    @TableField("phone")
    private String phone;

    /**
     * 等级
     */
    @TableField("level")
    private Integer level;

    /**
     * 余额
     */
    @TableField("amount")
    private BigDecimal amount;

}