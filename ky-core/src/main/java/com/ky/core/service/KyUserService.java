package com.ky.core.service;

import com.ky.common.result.Result;
import com.ky.dao.entity.KyUserDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author weish
* @description 针对表【ky_user】的数据库操作Service
* @createDate 2023-04-20 16:30:01
*/
public interface KyUserService extends IService<KyUserDO> {
    Result<String> insertBatch();
}
