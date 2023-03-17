package com.bcs.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author bcs
 */
@SpringBootApplication
public class StudyApplication {

    public static void main(String[] args) {
        //测试提交
        SpringApplication.run(StudyApplication.class, args);

        /*
        * WebMvcConfigurer常用接口：
            1.addInterceptors：拦截器
            2.addViewControllers：页面跳转
            3. addResourceHandlers：静态资源
            4. configureDefaultServletHandling：默认静态资源处理器
            5. configureViewResolvers：视图解析器
            6. configureContentNegotiation：配置内容裁决的一些参数
            7. addCorsMappings：跨域
            8. configureMessageConverters：信息转换器
        * */
    }

}
