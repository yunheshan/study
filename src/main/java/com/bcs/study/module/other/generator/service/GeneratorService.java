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
    private static final String CLASS_PATH = "/src/main/java/com/bcs/study/module/";
    private static final String XML_PATH = "/src/main/resources/mapper/";

    @Autowired
    private GeneratorMapper generatorMapper;

    public void gen(BaseInfo baseInfo) {

        List<String> tableNames = baseInfo.getTableNames();
        tableNames.forEach(tableName -> {

                    //验证前缀和表名
                    String tablePrefix = baseInfo.getTablePrefix();
                    if (tableName.indexOf(tablePrefix) != 0) {
                        try {
                            throw new Exception("提供的前缀:" + tablePrefix + ",与当前表" + tableName + "前缀不一致!" );
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    //获取类名和包名
                    String className = getClassName(tableName, tablePrefix);
                    String lowerClassName = className.toLowerCase();
                    String packageName = baseInfo.getPackageName() + "." + tableName.split(tablePrefix)[1].replace("_", "" );

                    //验证表名是否准确
                    List<ColumnDTO> columns = generatorMapper.selectColumns(tableName);
                    if (ValidUtils.isEmpty(columns)) {
                        try {
                            throw new Exception("当前数据库中不存在此表:" + tableName);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    //构造导包语句和其他数据
                    Set<String> imports = new HashSet<>();
                    List<ColumnDTO> fullColumns = columns.stream()
                            .map(columnDTO -> getColumnDTO(imports, columnDTO))
                            .collect(Collectors.toList());
                    String tableDesc = generatorMapper.selectDesc(tableName);

                    // step1 创建freeMarker配置实例，参数：版本实例（FreeMarker 2.3.23之前不带参数的Configuration方法被弃用）
                    Configuration configuration = new Configuration(Configuration.VERSION_2_3_31);
                    Writer out = null;
                    try {
                        // step2 获取模版路径
                        configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
                        // step3 创建数据模型
                        ArrayList<String> importList = new ArrayList<>(imports);
                        Map<String, Object> dataMap = fillData(fullColumns, className,lowerClassName, tableName, baseInfo,packageName, importList, tableDesc);
                        Map<String, String> templateMap = GeneratorComponent.getTemplateMap(packageName, className);
                        Set<Map.Entry<String, String>> entries = templateMap.entrySet();
                        for (Map.Entry<String, String> entry : entries) {
                            // step4 加载模版文件
                            Template template = configuration.getTemplate(entry.getKey());
                            // step5 生成数据
                            File docFile;
                            if (entry.getKey().equals("dao.xml.ftl" )) {
                                docFile = new File(new File("" ).getCanonicalPath() + XML_PATH + entry.getValue());
                            } else {
                                docFile = new File(new File("" ).getCanonicalPath() + CLASS_PATH + entry.getValue());
                            }
                            int i = docFile.getCanonicalPath().lastIndexOf("\\" );
                            File tempFile = new File(docFile.getCanonicalPath().substring(0, i));
                            if (!tempFile.exists()) {
                                tempFile.mkdirs();
                                if (!docFile.exists()) {
                                    docFile.createNewFile();
                                }
                            }
                            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
                            // step6 输出文件
                            template.process(dataMap, out);
                        }
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

    /**
     * 根据得到列信息构造需要的模板数据
     *
     * @param imports   需要导包的set集合
     * @param columnDTO 待填充模板数据
     * @return
     */
    private ColumnDTO getColumnDTO(Set<String> imports, ColumnDTO columnDTO) {
        //构造字段类型
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

        //构造导包语句
        String columnName = columnDTO.getColumnName();
        if (!("id".equals(columnName) || "create_time".equals(columnName) || "update_time".equals(columnName) || "is_delete".equals(columnName))) {
            if ("BigDecimal".equals(javaType)) {
                imports.add("import java.math.BigDecimal;" );
            } else if ("LocalDateTime".equals(javaType)) {
                imports.add("import java.time.LocalDateTime;" );
            }
        }

        //构造字段命名
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
    }

    /**
     * 获取Class类名
     *
     * @param tableName
     * @param tablePrefix
     * @return
     */
    private String getClassName(String tableName, String tablePrefix) {
        String[] classNameSource = tableName.split(tablePrefix)[1].split("_" );
        StringBuilder classNameSb = new StringBuilder();

        for (String s : classNameSource) {
            char[] chars = s.toCharArray();
            chars[0] = (char) (chars[0] - 32);
            classNameSb.append(new String(chars));
        }
        return classNameSb.toString();
    }


    public static Map<String, Object> fillData(List<ColumnDTO> columns, String className,String lowerClassName, String tableName, BaseInfo baseInfo,String packageName, List<String> imports, String tableDesc) {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("columns", columns);
        dataMap.put("className", className);
        dataMap.put("tableName", tableName);
        dataMap.put("baseInfo", baseInfo);
        dataMap.put("packageName", packageName);
        dataMap.put("imports", imports);
        dataMap.put("tableDesc", tableDesc);
        dataMap.put("lowerClassName", lowerClassName);
        return dataMap;
    }
}
