package com.ky.common.dto.req;



import java.io.Serializable;

/**
 * <p>
 * 登录请求DTO
 * <p>
 *
 * @author WSH
 * @date 2022-11-07 10:02:44
 */
public class LoginDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;

    private String password;
}
