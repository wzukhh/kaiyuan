package com.ky.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ky.dao.entity.KyAdminDO;
import org.apache.ibatis.annotations.Mapper;

/**
* @author weish
* @description 针对表【ky_admin】的数据库操作Mapper
* @createDate 2023-04-12 17:23:11
* @Entity com.ky.dao.do.KyAdmin
*/
@Mapper
public interface KyAdminMapper extends BaseMapper<KyAdminDO> {
}




