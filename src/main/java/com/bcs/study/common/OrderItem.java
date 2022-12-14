package com.bcs.study.common;

import lombok.Data;

/**
 * @Author bcs
 * @Date 2022/12/14 10:18
 * @Version 1.0
 * @Desc
 */
@Data
public class OrderItem {

    private String column;

    private boolean asc = true;
}
