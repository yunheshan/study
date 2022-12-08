package com.bcs.study.module.business.admin.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
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
@TableName("t_admin")
public class Admin implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

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
