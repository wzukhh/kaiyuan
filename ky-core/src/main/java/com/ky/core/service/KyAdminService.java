package com.ky.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ky.common.result.Result;
import com.ky.dao.entity.KyAdminDO;
import com.ky.dto.req.LoginDTO;
import com.ky.dto.req.LogoutDTO;

/**
* @author weish
* @description 针对表【ky_admin】的数据库操作Service
* @createDate 2023-04-12 17:23:11
*/
public interface KyAdminService extends IService<KyAdminDO> {

    Result<String> login(LoginDTO loginDTO);

    Result<String> logout(LogoutDTO loginDTO);
}
