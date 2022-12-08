package com.bcs.study.module.other.generator.service;

import com.bcs.study.module.other.generator.bean.BaseInfo;
import com.bcs.study.module.other.generator.bean.ColumnDTO;
import com.bcs.study.module.other.generator.mapper.GeneratorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @Author bcs
 * @Date 2022/12/8 16:17
 * @Version 1.0
 * @Desc
 */
@Service
public class GeneratorService {

    @Autowired
    private GeneratorMapper generatorMapper;

    public void gen() {
        BaseInfo baseInfo = BaseInfo.builder()
                .author("bcs")
                .tablePrefix("t_")
                .tableNames(Collections.singletonList("t_admin"))
                .packageName("com.bcs.study.module.business")
                .build();
        List<String> tableNames = baseInfo.getTableNames();
        tableNames.forEach(tableName -> {
                    List<ColumnDTO> columns = generatorMapper.selectColumns(tableName);
                    String tableDesc = generatorMapper.selectDesc(tableName);
                }
        );
    }
}
