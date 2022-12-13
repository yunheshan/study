package com.bcs.study;

import com.bcs.study.module.other.generator.mapper.GeneratorMapper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudyApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestWithSpring {

    @Autowired
    private GeneratorMapper generatorMapper;

    @BeforeAll
    static void before(){

    }

    @AfterAll
    static void after(){

    }

    @Test
    public void test() throws IOException {
//        System.out.println(generatorMapper.selectDesc("t_admin"));
//        generatorMapper.selectColumns("t_admin").forEach(System.out::println);
        File file = new File("" );
        String canonicalPath = file.getCanonicalPath();
        System.out.println(canonicalPath);
    }

}
