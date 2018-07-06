package com.bluepro.boy.handle;

import com.bluepro.boy.domain.Result;
import com.bluepro.boy.exception.BoyException;
import com.bluepro.boy.util.BoyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: XieLiang
 * @Date : 2018/7/6
 * @Comment :
 */
@ControllerAdvice
/**用于拦截异常并统一处理
 * 如果全部异常处理返回json，
 * 那么可以使用 @RestControllerAdvice 代替 @ControllerAdvice ，这样在方法上就可以不需要添加 @ResponseBody
 * */
public class ExceptionHandle {

    @Autowired
    private BoyUtil boyUtil;

    /** ExceptionHandler用于标识哪个异常类需要被处理 */
    @ExceptionHandler(value = BoyException.class)
    @ResponseBody
    /** @ResponseBody
    　　public User login(User user){
    　　　　return user;
    　　}User字段：userName pwd,那么在前台接收到的数据为：'{"userName":"xxx","pwd":"xxx"}'
    　　效果等同于如下代码：
    　　public void login(User user, HttpServletResponse response){
    　　　　response.getWriter.write(JSONObject.fromObject(user).toString());
    　　} */
    public Result handle(Exception e){
        /** 判断service抛出的异常是否为自定义的异常，如果是，则获取e里的code与message */
        if(e instanceof BoyException){
            BoyException boyException = (BoyException) e;
            return boyUtil.error(boyException.getCode(),boyException.getMessage());
        }
        return boyUtil.sysError();
    }
}
