package com.bcs.study.module.admin.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 管理员表
 * </p>
 *
 * @author bcs
 * @since 2022-12-07
 */
@Data
@Schema(title = "管理员DTO对象",description = "管理实体描述")
public class AdminDTO {

    @Schema(title = "管理员用户名标题",description = "用户名描述")
    private String name;

    private String password;

    private BigDecimal amount;

    private Integer status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer isDelete;


}
