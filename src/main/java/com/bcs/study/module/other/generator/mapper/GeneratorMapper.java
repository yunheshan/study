package com.bcs.study.module.other.generator.mapper;

import com.bcs.study.module.other.generator.bean.ColumnDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author bcs
 * @Date 2022/12/8 15:11
 * @Version 1.0
 * @Desc
 */
@Mapper
public interface GeneratorMapper {

    /**
     * 根据表名获取表描述
     * @param tableName
     * @return
     */
    String selectDesc(@Param("tableName") String tableName);

    /**
     * 根据表名获取表的列信息
     * @param tableName
     * @return
     */
    List<ColumnDTO> selectColumns (@Param("tableName") String tableName);

}
