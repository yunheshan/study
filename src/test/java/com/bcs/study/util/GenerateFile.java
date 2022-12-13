package com.bcs.study.util;

import java.util.*;

import com.bcs.study.StudyApplication;
import com.bcs.study.module.other.generator.bean.BaseInfo;
import com.bcs.study.module.other.generator.service.GeneratorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author bcs
 * @Date 2022/12/9 10:04
 * @Version 1.0
 * @Desc 代码生成器
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudyApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GenerateFile {


    @Autowired
    private GeneratorService generatorService;


    @Test
    public void test() {
        BaseInfo baseInfo = BaseInfo.builder()
                //输入作者名
                .author("bcs")
                //输入表的前缀
                .tablePrefix("t_")
                //输入要生成的表
                .tableNames(Arrays.asList("t_user","t_admin"))
                //输入模块包名(如业务包business)
                .packageName("business")
                .build();
        generatorService.gen(baseInfo);
    }


}
