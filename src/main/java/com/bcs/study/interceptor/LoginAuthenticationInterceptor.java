package com.bcs.study.interceptor;

import com.bcs.study.util.ValidUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @Author bcs
 * @Date 2023/3/17 11:49
 * @Version 1.0
 * @Desc
 */
@Component
@Slf4j
public class LoginAuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("执行了登录验证拦截器");
        log.info(request.getRequestURI());
        String loginToken = request.getHeader("loginToken");
        if (ValidUtils.isEmpty(loginToken)) {
            return false;
        }
        return true;
    }
}
