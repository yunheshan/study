package com.bcs.study.common.constant;

/**
 * @Author bcs
 * @Date 2022/12/8 14:35
 * @Version 1.0
 * @Desc 响应信息枚举类
 */
public enum ConstantOfResponse {

    //通用成功
    SUCCESS(200, "操作成功!", true),
    //通用失败
    FAIL(400, "操作失败!", false);

    ConstantOfResponse(Integer code, String msg, Boolean status) {
        this.code = code;
        this.msg = msg;
        this.status = status;
    }

    public final Integer code;

    public final String msg;

    public final Boolean status;

}
