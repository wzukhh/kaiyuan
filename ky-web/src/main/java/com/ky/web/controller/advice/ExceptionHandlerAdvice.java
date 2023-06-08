package com.ky.web.controller.advice;

import com.ky.common.constants.KyEnum;
import com.ky.common.exception.BizException;
import com.ky.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p>
 *
 * <p>
 *
 * @author WSH
 * @date 2022-11-07 10:02:44
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(BizException.class)
    public Result handlerNullException(BizException e) {
        log.error(e.getMessage(),e);
        return Result.fail(e.getError_code(),e.getError_msg());
    }

    @ExceptionHandler(RuntimeException.class)
    public Result handlerNullException(RuntimeException e) {
        log.error(e.getMessage(),e);
        if (e instanceof BizException){
            return Result.fail(((BizException) e).getError_code(),((BizException) e).getError_msg());
        }
        return Result.fail();
    }

    @ExceptionHandler(Exception.class)
    public Result handlerException(Exception e) {
        log.error(e.getMessage(),e);
        return Result.fail();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handlerException(MethodArgumentNotValidException e) {
        log.error(e.getMessage(),e);
        return Result.fail(KyEnum.FAIL.getCode(),e.getBindingResult().getFieldError().getDefaultMessage());
    }
}
