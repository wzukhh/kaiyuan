package com.ky.web.controller.ctl;

import com.alibaba.fastjson.JSON;
import com.ky.common.constants.KyConstants;
import com.ky.common.result.Result;
import com.ky.core.service.KyAdminService;
import com.ky.core.service.KyUserService;
import com.ky.dto.req.LoginDTO;
import com.ky.dto.req.LogoutDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * <p>
 *  登录相关控制器
 * <p>
 *
 * @author WSH
 * @date 2022-11-07 10:02:44
 */
@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private KyAdminService kyAdminService;
    @Autowired
    private KyUserService kyUserService;

    @PostMapping("/login")
    public Result<String> login(@Valid @RequestBody LoginDTO loginDTO, HttpServletResponse response){
        log.info("login input params {}", JSON.toJSONString(loginDTO));
        Result<String> result = kyAdminService.login(loginDTO);
        if (KyConstants.SUCCESS.equals(result.getCode())){
            //登录成功，token添加到Cookie里边
            response.addCookie(new Cookie(KyConstants.ACCESS_TOKEN,result.getData()));
        }
        return result;
    }

    @PostMapping("/logout")
    public Result<String> logout(@Valid @RequestBody LogoutDTO logoutDTO){
        log.info("logout input params {}", JSON.toJSONString(logoutDTO));
        return kyAdminService.logout(logoutDTO);
    }

    @PostMapping("/add")
    public Result<String> batchAdd(){
        return kyUserService.insertBatch();
    }
}
