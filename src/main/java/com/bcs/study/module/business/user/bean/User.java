package com.bcs.study.module.business.user.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author bcs
 * @since 2022-12-08
 */
@Data
@TableName("t_user")
@Schema(name = "User", description = "用户类")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Long id;

    @Schema(description = "用户名")
    @TableField("name")
    private String name;

    @Schema(description = "密码")
    @TableField("password")
    private String password;

    @Schema(description = "昵称")
    @TableField("nickname")
    private String nickname;

    @Schema(description = "手机号")
    @TableField("phone")
    private String phone;

    @Schema(description = "等级")
    @TableField("level")
    private Byte level;

    @Schema(description = "余额")
    @TableField("amount")
    private BigDecimal amount;

    @Schema(description = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @Schema(description = "是否删除")
    @TableField("is_delete")
    private Byte isDelete;
}
