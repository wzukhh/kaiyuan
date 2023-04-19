package com.ky.web.controller.filter;

import com.ky.common.constants.KyConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

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
 *
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

    @Value("filter.excludes.uris")
    private String[] excludes;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getServletPath();
        // 放行路径包含该请求uri，放行
        if (handleExcludeUri(uri)){
            filterChain.doFilter(request,response);
        }
        String headerToken = request.getHeader(KyConstants.ACCESS_TOKEN);
        // 请求没有token，直接拒绝，说明没有登录
        if (headerToken == null){
            return;
        }


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
