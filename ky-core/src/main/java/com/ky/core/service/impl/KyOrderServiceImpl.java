package com.ky.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ky.dao.entity.KyOrderDO;
import com.ky.core.service.KyOrderService;
import com.ky.dao.mapper.KyOrderMapper;
import org.springframework.stereotype.Service;

/**
* @author weish
* @description 针对表【ky_order】的数据库操作Service实现
* @createDate 2023-04-13 15:13:25
*/
@Service
public class KyOrderServiceImpl extends ServiceImpl<KyOrderMapper, KyOrderDO>
    implements KyOrderService {

}




