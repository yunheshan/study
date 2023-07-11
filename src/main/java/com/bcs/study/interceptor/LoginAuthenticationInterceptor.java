package com.bcs.study.interceptor;

import com.bcs.study.util.ValidUtils;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        log.info("执行了登录验证拦截器");
        String loginToken = request.getHeader("loginToken");
        if(ValidUtils.isEmpty(loginToken)){
            return false;
        }
        return true;
    }
}
