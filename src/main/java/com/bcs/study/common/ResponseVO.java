package com.bcs.study.common;

import com.bcs.study.common.constant.ConstantOfResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author bcs
 * @Date 2022/12/8 14:28
 * @Version 1.0
 * @Desc 通用请求响应信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseVO<T> {

    private Integer code;

    private String msg;

    private Boolean status;

    private T data;

    public ResponseVO(ConstantOfResponse constantOfResponse) {
        this.code = constantOfResponse.code;
        this.msg = constantOfResponse.msg;
        this.status = constantOfResponse.status;
    }

    public ResponseVO(ConstantOfResponse constantOfResponse, String msg) {
        this.code = constantOfResponse.code;
        this.msg = msg;
        this.status = constantOfResponse.status;
    }

    public ResponseVO(ConstantOfResponse constantOfResponse, T data) {
        this.code = constantOfResponse.code;
        this.msg = constantOfResponse.msg;
        this.status = constantOfResponse.status;
        this.data = data;
    }



    public static ResponseVO success() {
        return new ResponseVO(ConstantOfResponse.SUCCESS);
    }

    public static <T> ResponseVO<T> successData(T data) {
        return new ResponseVO(ConstantOfResponse.SUCCESS, data);
    }

    public static ResponseVO fail() {
        return new ResponseVO(ConstantOfResponse.FAIL);
    }

    public static ResponseVO fail(String msg) {
        return new ResponseVO(ConstantOfResponse.FAIL, msg);
    }

    public static <T> ResponseVO<T> failData(T data) {
        return new ResponseVO(ConstantOfResponse.FAIL, data);
    }

    public static ResponseVO diy(Integer code,String msg,Boolean status) {
        return new ResponseVO(code,msg,status,null);
    }

    public static <T> ResponseVO<T> diyData(Integer code,String msg,Boolean status,T data) {
        return new ResponseVO(code,msg,status,data);
    }

}
