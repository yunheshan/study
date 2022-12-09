package com.bcs.study;

import com.bcs.study.module.other.generator.mapper.GeneratorMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @Author bcs
 * @Date 2022/12/6 16:15
 * @Version 1.0
 * @Desc
 */
public class TestWithoutSpring {

    @Test
    public void test(){
        String s = "t_";
        String s1 = "t_admin_t_sb";
        String s2 = "_";
        String s3 = "t_admin";
        System.out.println(s1.indexOf(s));
        String[] split = s3.split(s);
        System.out.println(split[1]);
        System.out.println(".".split("\\.").length);
    }
    @Test
    public void test2() throws ClassNotFoundException {

        String s = "java.lang.String";
        String canonicalName = Class.forName(s).getCanonicalName();
        System.out.println(canonicalName);
    }
}
