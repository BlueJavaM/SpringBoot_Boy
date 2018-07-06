package com.bluepro.boy.exception;

/**
 * @Author: XieLiang
 * @Date : 2018/7/6
 * @Comment :
 */

public class BoyException extends RuntimeException {
    private Integer code;

    public BoyException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


}
