package com.ky.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ky.common.dto.req.LoginDTO;
import com.ky.common.res.Result;
import com.ky.dao.entity.KyAdminDO;

/**
* @author weish
* @description 针对表【ky_admin】的数据库操作Service
* @createDate 2023-04-12 17:23:11
*/
public interface KyAdminService extends IService<KyAdminDO> {

    Result<String> login(LoginDTO loginDTO);
}
