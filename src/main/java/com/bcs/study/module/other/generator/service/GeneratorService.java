package com.bcs.study.module.other.generator.service;

import com.bcs.study.module.other.generator.bean.BaseInfo;
import com.bcs.study.module.other.generator.bean.ColumnDTO;
import com.bcs.study.module.other.generator.mapper.GeneratorMapper;
import com.bcs.study.util.ValidUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author bcs
 * @Date 2022/12/8 16:17
 * @Version 1.0
 * @Desc
 */
@Service
public class GeneratorService {

    private static final String TEMPLATE_PATH = "src/main/resources/templates/freemarker";
    private static final String CLASS_PATH = "src/main/java/com/bcs/study/module/";

    @Autowired
    private GeneratorMapper generatorMapper;

    public void gen(BaseInfo baseInfo) {

        List<String> tableNames = baseInfo.getTableNames();
        tableNames.forEach(tableName -> {
                    String tablePrefix = baseInfo.getTablePrefix();
                    if (tableName.indexOf(tablePrefix) != 0) {
                        try {
                            throw new Exception("提供的前缀:" + tablePrefix + ",与当前表" + tableName + "前缀不一致!" );
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    String[] classNameSource = tableName.split(tablePrefix)[1].split("_" );
                    StringBuilder classNameSb = new StringBuilder();
                    baseInfo.setPackageName(baseInfo.getPackageName() + "." + tableName.split(tablePrefix)[1].replace("_", "" ));
                    for (String s : classNameSource) {
                        char[] chars = s.toCharArray();
                        chars[0] = (char) (chars[0] - 32);
                        classNameSb.append(new String(chars));
                    }
                    String className = classNameSb.toString() + "Entity";
                    List<ColumnDTO> columns = generatorMapper.selectColumns(tableName);
                    List<String> imports = new ArrayList<>();
                    List<ColumnDTO> fullColumns = columns.stream()
                            .map(columnDTO -> {
                                String columnType = columnDTO.getColumnType();
                                String javaType = GeneratorComponent.getJavaType(columnType);
                                if (ValidUtils.isEmpty(javaType)) {
                                    try {
                                        throw new Exception("所选数据库类型:" + columnType + ",没有所对应的Java类型!" );
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                columnDTO.setFiledType(javaType);
                                if (!imports.contains("import java.math.BigDecimal;" ) && "BigDecimal".equals(javaType)) {
                                    imports.add("import java.math.BigDecimal;" );
                                } else if (!imports.contains("import java.time.LocalDateTime;" ) && "LocalDateTime".equals(javaType)) {
                                    imports.add("import java.time.LocalDateTime;" );
                                }
                                String columnName = columnDTO.getColumnName();
                                StringBuilder columnNameSb = new StringBuilder();
                                String[] s = columnName.split("_" );
                                if (s.length == 1) {
                                    columnDTO.setFiledName(s[0]);
                                } else {
                                    columnNameSb.append(s[0]);
                                    for (int i = 1; i < s.length; i++) {
                                        char[] chars = s[i].toCharArray();
                                        chars[0] = (char) (chars[0] - 32);
                                        columnNameSb.append(new String(chars));
                                    }
                                    columnDTO.setFiledName(columnNameSb.toString());
                                }

                                return columnDTO;
                            }).collect(Collectors.toList());
                    String tableDesc = generatorMapper.selectDesc(tableName);

                    // step1 创建freeMarker配置实例，参数：版本实例（FreeMarker 2.3.23之前不带参数的Configuration方法被弃用）
                    Configuration configuration = new Configuration(Configuration.VERSION_2_3_31);
                    Writer out = null;
                    try {
                        // step2 获取模版路径
                        configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
                        // step3 创建数据模型
                        Map<String, Object> dataMap = fillData(fullColumns, className, tableName, baseInfo, imports, tableDesc);
                        // step4 加载模版文件
                        Template template = configuration.getTemplate("entity.ftl" );
                        // step5 生成数据
                        File docFile = new File(CLASS_PATH + baseInfo.getPackageName().replace(".", "/" ) + "/bean/" + className + ".java" );
                        out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
                        // step6 输出文件
                        template.process(dataMap, out);
                        System.out.println("文件创建成功 !" );
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (null != out) {
                                out.flush();
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
        );
    }


    public static Map<String, Object> fillData(List<ColumnDTO> columns, String className, String tableName, BaseInfo baseInfo, List<String> imports,String tableDesc) {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("columns", columns);
        dataMap.put("className", className);
        dataMap.put("tableName", tableName);
        dataMap.put("baseInfo", baseInfo);
        dataMap.put("imports", imports);
        dataMap.put("tableDesc", tableDesc);
        return dataMap;
    }
}
