package com.ky.web.controller.filter;

import com.ky.common.constants.KyConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 请求过滤器，对每一个请求进行过滤，判断用户是否登录
 * <p>
 *
 * @author WSH
 * @date 2022-11-07 10:02:44
 */
@Slf4j
@Component
@WebFilter(filterName = "CommonFilter", urlPatterns = "/**")
public class CommonFilter implements Filter {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Value("${filter.excludes}")
    private String[] excludes;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getServletPath();
        // 放行路径包含该请求uri，放行
        if (handleExcludeUri(uri)){
            filterChain.doFilter(request,response);
            return;
        }
        String headerToken = request.getHeader(KyConstants.ACCESS_TOKEN);
        // 请求没有token，直接拒绝，说明没有登录
        if (StringUtils.isEmpty(headerToken)){
            return;
        }
        // 获取redis里边的token
        String redisToken = redisTemplate.opsForValue().get(headerToken);
        if (StringUtils.isEmpty(redisToken) || !redisToken.equals(headerToken)){
            return;
        }
        log.info("request header accessToken: {} ; request uri: {} ; redis token: {}",headerToken,uri,redisToken);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    private boolean handleExcludeUri(String uri) {
        if (excludes == null || excludes.length == 0){
            return true;
        }
        for (String exclude : excludes) {
            if (exclude.equals(uri)){
                return true;
            }
        }
        return false;
    }
}
