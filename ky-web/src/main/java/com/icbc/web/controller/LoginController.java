package com.icbc.web.controller;

import com.alibaba.fastjson.JSON;
import com.ky.common.dto.req.LoginDTO;
import com.ky.common.res.Result;
import com.ky.core.service.KyAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  管理员相关控制器，登录和管理
 * <p>
 *
 * @author WSH
 * @date 2022-11-07 10:02:44
 */
@Slf4j
@RestController
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    private KyAdminService kyAdminService;

    @PostMapping("/login")
    public Result<String> login(@RequestBody LoginDTO loginDTO){
        log.info("login input params {}", JSON.toJSONString(loginDTO));
        return kyAdminService.login(loginDTO);
    }


}
