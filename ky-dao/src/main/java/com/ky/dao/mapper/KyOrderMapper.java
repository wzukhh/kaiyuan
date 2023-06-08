package com.ky.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ky.dao.entity.KyOrderDO;
import org.apache.ibatis.annotations.Mapper;

/**
* @author weish
* @description 针对表【ky_order】的数据库操作Mapper
* @createDate 2023-04-13 15:13:25
* @Entity com.ky.dao.entity.KyOrderDO
*/
@Mapper
public interface KyOrderMapper extends BaseMapper<KyOrderDO> {

}




