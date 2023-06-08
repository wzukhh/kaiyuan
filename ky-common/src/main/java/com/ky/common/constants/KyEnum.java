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
    // 通用
    SUCCESS("0","操作成功"),
    FAIL("-1","操作失败"),

    /**
     * 0: 所有操作成功时返回
     *
     */

    // 登录、注册相关
    LOGIN_SUCCESS("0","登录成功"),
    LOGIN_FAIL("-1","登录失败"),
    USER_NOT_EXIST("-1","用户名不存在"),
    PASSWORD_WRONG("-1","密码错误，请输入正确密码"),


    ;

    private final String  code;
    private final String msg;

    KyEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }
}
