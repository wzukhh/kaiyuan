package com.ky.common.utils;

import com.ky.common.constants.KyConstants;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * <p>
 *
 * @author WSH
 * @date 2022-11-07 10:02:44
 */
public class RedisUtils {
    /**
     * redis中存入token,并设置过期时间, token值为key + 过期时间
     * @param key   key
     * @param ExpirationTime    存入时的系统时间毫秒值 + 自定义过期时间
     * @param redisTemplate     redisTemplate
     * @return   生成的token
     */
    public static String setToken(String key, Long ExpirationTime, RedisTemplate<String, String> redisTemplate) {
        String token = key + "&&" + ExpirationTime;
        redisTemplate.opsForValue().set(token, KyConstants.EXIST, ExpirationTime, TimeUnit.MILLISECONDS);
        return token;
    }

    /**
     * 获取指定key的过期时间
     * @param key   key
     * @param redisTemplate     redisTemplate
     * @return  存入时的系统时间毫秒值 + 自定义过期时间
     */
    public static Long getExpirationTimeOfKey(String key, RedisTemplate<String, String> redisTemplate) {
        try {
            String value = redisTemplate.opsForValue().get(key);
            assert value != null;
            String ExpirationTime = value.substring(value.indexOf("&&") + 2);
            return Long.parseLong(ExpirationTime);
        } catch (Exception e) {
            return  -1L;
        }
    }
}
