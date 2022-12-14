package com.bcs.study.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author bcs
 * @Date 2022/12/8 11:18
 * @Version 1.0
 * @Desc springDOC配置类(代替Swagger3)
 */
@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI studyOpenApi() {
        return new OpenAPI()
                .info(new Info().title("个人学习项目SpringDoc文档")
                        .description("学习用")
                        .version("v1.0.0"));
    }
}

