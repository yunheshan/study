package com.bcs.study;

import com.bcs.study.module.other.generator.mapper.GeneratorMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author bcs
 * @Date 2022/12/6 16:15
 * @Version 1.0
 * @Desc
 */
public class TestWithoutSpring {

    @Test
    public void test(){
        System.out.println(".".split("\\.").length);
    }
}
