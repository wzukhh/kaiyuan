package com.ky.common.exception;

import com.ky.common.constants.KyEnum;
import lombok.Getter;

/**
 * <p>
 *
 * <p>
 *
 * @author WSH
 * @date 2022-11-07 10:02:44
 */
public class BizException extends RuntimeException{
    @Getter
    private String error_code;
    @Getter
    private String error_msg;

    public BizException(String error_code, String error_msg){
        super(error_msg);
        this.error_code = error_code;
        this.error_msg = error_msg;
    }

    public BizException(KyEnum kyEnum){
        super(kyEnum.getMsg());
        this.error_code = kyEnum.getCode();
        this.error_msg = kyEnum.getMsg();
    }
}
