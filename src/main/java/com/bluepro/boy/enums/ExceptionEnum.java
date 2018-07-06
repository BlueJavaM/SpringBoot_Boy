package com.bluepro.boy.enums;

/**
 * @Author: XieLiang
 * @Date : 2018/7/6
 * @Comment :
 */
public enum ExceptionEnum {
    SYSTEM_ERROR(-1,"未知错误"),
    ERROR(0,"失败"),
    SUCCESS(1,"成功"),
    LITTLE_BOY(2,"你怕是毛都还没长齐吧！"),
    MAN(3,"你现在可能饥渴难耐了吧！"),
    OLD_MAN(4,"你可能已经有心无力了吧！"),
    ;
    private Integer code;
    private String msg;

    ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
