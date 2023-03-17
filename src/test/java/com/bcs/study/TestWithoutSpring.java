package com.bcs.study;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

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
    @Test
    public void test3() throws IOException {

//        String s = "java";
//        String substring = s.substring(0,1);
//        System.out.println(substring);
//        new FileOutputStream()
        File file = new File("" );
        System.out.println(file.getCanonicalPath());
    }
}
