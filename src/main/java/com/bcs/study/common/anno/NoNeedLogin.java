package com.bcs.study.common.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * [ 无需登录 ]
 *
 * @Author bcs
 * @Date 2023/3/17 13:23
 * @Version 1.0
 * @Desc
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NoNeedLogin {
}
