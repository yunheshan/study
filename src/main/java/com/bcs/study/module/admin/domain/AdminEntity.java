package com.bcs.study.module.admin.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author bcs
 * @Date 2022/12/6 13:52
 * @Version 1.0
 * @Desc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -1684477853159641057L;

    private Integer id;

    private String name;

    private String password;

    private String phoneNum;

    private Integer age;

    private LocalDateTime registerTime;

    private BigDecimal amount;
}
