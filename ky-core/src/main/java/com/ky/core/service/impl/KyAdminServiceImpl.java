package com.ky.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ky.common.dto.req.LoginDTO;
import com.ky.common.res.Result;
import com.ky.core.service.KyAdminService;
import com.ky.dao.entity.KyAdminDO;
import com.ky.dao.mapper.KyAdminMapper;
import org.springframework.stereotype.Service;

/**
* @author weish
* @description 针对表【ky_admin】的数据库操作Service实现
* @createDate 2023-04-12 17:23:11
*/
@Service
public class KyAdminServiceImpl extends ServiceImpl<KyAdminMapper, KyAdminDO> implements KyAdminService{

    @Override
    public Result<String> login(LoginDTO loginDTO) {

        return null;
    }
}




