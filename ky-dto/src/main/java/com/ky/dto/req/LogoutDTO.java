package com.ky.dto.req;



import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * <p>
 * 登录请求DTO
 * <p>
 *
 * @author WSH
 * @date 2022-11-07 10:02:44
 */
@Data
public class LogoutDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "用户名不能为空！")
    private String username;
}
