package com.ky.common.constants;

/**
 * <p>
 * 枚举类
 * <p>
 *
 * @author WSH
 * @date 2022-11-07 10:02:44
 */
public enum KyEnum {
    SUCCESS(0,"操作成功"),
    WRONG(-1,"操作失败"),
    LOGIN_OK(0,"登录成功"),
    LOGIN_FAIL(-1,"登录失败"),
    ;

    private final int code;
    private final String msg;

    KyEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }
}
