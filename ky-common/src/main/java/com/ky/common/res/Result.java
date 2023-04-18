package com.ky.common.res;

import com.ky.common.constants.KyEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *
 * <p>
 *
 * @author WSH
 * @date 2022-11-07 10:02:44
 */
@Data
public class Result<T> implements Serializable {
    private int code;
    private String msg;
    private T data;

    public Result(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Result(KyEnum kyEnum) {
        this.code = kyEnum.getCode();
        this.msg = kyEnum.getMsg();
    }

    public static <T> Result<T> ok(int code, String msg, T data){
        return new Result<T>(code,msg,data);
    }


    public static <T> Result<T> ok(int code, String msg){
        return new Result<T>(code,msg);
    }

    public static <T> Result<T> ok(KyEnum kyEnum){
        return new Result<T>(kyEnum);
    }

    public static <T> Result<T> ok(KyEnum kyEnum,T data){
        return new Result<T>(kyEnum.getCode(),kyEnum.getMsg(),data);
    }
    public static <T> Result<T> ok(){
        return new Result<T>(KyEnum.SUCCESS);
    }

    public static <T> Result<T> fail(int code, String msg, T data){
        return new Result<T>(code,msg,data);
    }

    public static <T> Result<T> fail(int code, String msg){
        return new Result<T>(code,msg);
    }

    public static <T> Result<T> fail(KyEnum kyEnum){
        return new Result<T>(kyEnum);
    }

    public static <T> Result<T> fail(KyEnum kyEnum,T data){
        return new Result<T>(kyEnum.getCode(),kyEnum.getMsg(),data);
    }

    public static <T> Result<T> fail(){
        return new Result<T>(KyEnum.WRONG);
    }
}
