package com.bcs.study.config;

import com.bcs.study.interceptor.LoginAuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author bcs
 * @Date 2023/3/17 13:07
 * @Version 1.0
 * @Desc
 */
@Configuration
public class LoginAuthenticationConfig implements WebMvcConfigurer {

    @Autowired
    private LoginAuthenticationInterceptor loginAuthenticationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginAuthenticationInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/ex/", "/swagger-ui/", "/api-docs/");
    }
}
