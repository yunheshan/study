package com.bcs.study.module.other.generator.controller;

import com.bcs.study.module.other.generator.bean.ColumnDTO;
import com.bcs.study.module.other.generator.mapper.GeneratorMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author bcs
 * @Date 2022/12/8 16:01
 * @Version 1.0
 * @Desc
 */
@RestController
@Tag(name = "测试")
public class GenController {

    @Autowired
    private GeneratorMapper generatorMapper;

    @GetMapping("/testGen")
    @Operation(summary = "测试")
    private List<ColumnDTO> listAll(){
        List<ColumnDTO> tAdmin = generatorMapper.selectColumns("t_admin");
        tAdmin.forEach(System.out::println);
        return tAdmin;
    }
}
