package com.bcs.study.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
/**
 * @Author bcs
 * @Date 2022/12/7 17:02
 * @Version 1.0
 * @Desc
 */
@Configuration
public class Swagger2Config implements WebMvcConfigurer{

    //    http://localhost:8088/swagger-ui.html     原路径
    //    http://localhost:8088/doc.html     原路径

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
//                .enable(true)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bcs.study.module.admin.controller"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("学习项目接口api")
                .contact(new Contact("bcs",
                        "none",
                        "508146801@qq.com"))
                .description("学习项目接口api文档")
                .version("1.0.0")
                .termsOfServiceUrl("xxx")
                .build();
    }

}
