package cn.zzuli.exceptionhandlers;

import cn.zzuli.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptoon {

    // 定义异常处理的Handler
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        // 打印异常信息
        e.printStackTrace();
        log.error("代码出现异常，异常信息为: {} " + e.getMessage());
        // 返回错误信息
        return Result.error(e.getMessage());
    }
}
