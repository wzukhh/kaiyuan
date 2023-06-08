package com.ky.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ky.common.constants.KyConstants;
import com.ky.common.constants.KyEnum;
import com.ky.common.result.Result;
import com.ky.common.utils.RedisUtils;
import com.ky.core.service.KyAdminService;
import com.ky.dao.entity.KyAdminDO;
import com.ky.dao.mapper.KyAdminMapper;
import com.ky.dto.req.LoginDTO;
import com.ky.dto.req.LogoutDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
* @author weish
* @description 针对表【ky_admin】的数据库操作Service实现
* @createDate 2023-04-12 17:23:11
*/
@Service
public class KyAdminServiceImpl extends ServiceImpl<KyAdminMapper, KyAdminDO> implements KyAdminService{
    @Autowired
    private KyAdminMapper kyAdminMapper;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 登录
     * @param loginDTO  登录请求实体
     * @return  公用结果类
     */
    @Override
    public Result<String> login(LoginDTO loginDTO) {
        String username = loginDTO.getUsername();
        KyAdminDO kyAdminDO = kyAdminMapper.selectOne(new LambdaQueryWrapper<KyAdminDO>().eq(KyAdminDO::getUsername, username).eq(KyAdminDO::getValid, KyConstants.VALID));
        // 用户不存在
        if (Objects.isNull(kyAdminDO)){
            return  Result.fail(KyEnum.USER_NOT_EXIST);
        }
        // 密码不正确
        if(!kyAdminDO.getPassword().equals(loginDTO.getPassword())){
            return  Result.fail(KyEnum.PASSWORD_WRONG);
        }
        // 登录成功，签发token，存入redis，并返回给前端，前端拿到之后在后续的请求时，把token添加到请求头上
        String accessToken = RedisUtils.setToken(username,KyConstants.ONE, TimeUnit.DAYS,redisTemplate);
        if (KyConstants.FAIL.equals(accessToken)){
            // token设置失败，返回登录失败，不显示具体信息
            return Result.fail(KyEnum.LOGIN_FAIL);
        }
        return Result.ok(KyEnum.LOGIN_SUCCESS,accessToken);
    }

    /**
     * 登出
     * @param logoutDTO  登出请求实体
     * @return  公用结果类
     */
    @Override
    public Result<String> logout(LogoutDTO logoutDTO) {
        Long time = RedisUtils.getExpirationTimeOfKey(logoutDTO.getUsername(), redisTemplate);
        if (time != null && time != -1){
            redisTemplate.delete(logoutDTO.getUsername());
        }
        return Result.ok();
    }
}




