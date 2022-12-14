package com.bcs.study.common;

import com.bcs.study.common.constant.ResponseEnum;
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
public class ResponseDTO<T> {

    private Integer code;

    private String msg;

    private Boolean status;

    private T data;

    public ResponseDTO(ResponseEnum responseEnum) {
        this.code = responseEnum.code;
        this.msg = responseEnum.msg;
        this.status = responseEnum.status;
    }

    public ResponseDTO(ResponseEnum responseEnum, String msg) {
        this.code = responseEnum.code;
        this.msg = msg;
        this.status = responseEnum.status;
    }

    public ResponseDTO(ResponseEnum responseEnum, T data) {
        this.code = responseEnum.code;
        this.msg = responseEnum.msg;
        this.status = responseEnum.status;
        this.data = data;
    }



    public static ResponseDTO success() {
        return new ResponseDTO(ResponseEnum.SUCCESS);
    }

    public static <T> ResponseDTO<T> successData(T data) {
        return new ResponseDTO(ResponseEnum.SUCCESS, data);
    }

    public static ResponseDTO fail() {
        return new ResponseDTO(ResponseEnum.FAIL);
    }

    public static ResponseDTO fail(String msg) {
        return new ResponseDTO(ResponseEnum.FAIL, msg);
    }

    public static <T> ResponseDTO<T> failData(T data) {
        return new ResponseDTO(ResponseEnum.FAIL, data);
    }

    public static ResponseDTO diy(Integer code, String msg, Boolean status) {
        return new ResponseDTO(code,msg,status,null);
    }

    public static <T> ResponseDTO<T> diyData(Integer code, String msg, Boolean status, T data) {
        return new ResponseDTO(code,msg,status,data);
    }

}
