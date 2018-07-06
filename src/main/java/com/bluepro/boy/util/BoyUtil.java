package com.bluepro.boy.util;

import com.bluepro.boy.domain.Result;
import com.bluepro.boy.enums.ExceptionEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: XieLiang
 * @Date : 2018/7/6
 * @Comment : 工具类，将相同代码统一管理
 */
@Component
public class BoyUtil {

    @Autowired
    private Result result;

    public Result success(Object object){
        result.setCode(ExceptionEnum.SUCCESS.getCode());
        result.setMessage(ExceptionEnum.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }

    public Result error(Integer code,String message){
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public Result sysError(){
        result.setCode(ExceptionEnum.SYSTEM_ERROR.getCode());
        result.setMessage(ExceptionEnum.SYSTEM_ERROR.getMsg());
        return null;
    }
}
