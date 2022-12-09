package com.bcs.study.module.business.admin.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.bcs.study.common.bean.BaseEntity;
import lombok.*;

/**
 * <p>
 * 管理员表
 * </p>
 *
 * @author bcs
 * @since 2022-12-07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("t_admin")
public class Admin extends BaseEntity {

    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private Long id;

    @TableField("name")
    private String name;

    @TableField("password")
    private String password;

    @TableField("amount")
    private BigDecimal amount;

    @TableField("status")
    private Integer status;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;

    @TableField("is_delete")
    private Integer isDelete;


}
