package com.ky.dao.mapper;

import com.ky.dao.entity.KyUserDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author weish
* @description 针对表【ky_user】的数据库操作Mapper
* @createDate 2023-04-20 16:30:01
* @Entity com.ky.dao.entity.KyUser
*/
@Mapper
public interface KyUserMapper extends BaseMapper<KyUserDO> {

    int insertBatch(@Param("userList") List<KyUserDO> userList);
}




