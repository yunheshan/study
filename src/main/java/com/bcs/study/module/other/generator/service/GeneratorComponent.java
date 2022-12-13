package com.bcs.study.module.other.generator.service;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author bcs
 * @Date 2022/12/9 15:20
 * @Version 1.0
 * @Desc
 */
@Component
public class GeneratorComponent {

    public static final HashMap<String, String> NUM_MAP = new HashMap<>(16);
    public static final HashMap<String, String> OTHER_MAP = new HashMap<>(16);

    static {
        initMap();
    }

    /**
     * 加载所有数据库到Java的类型映射到Map
     */
    private static void initMap() {
        NUM_MAP.put("int", "Integer" );
        NUM_MAP.put("tinyint", "Integer" );
        NUM_MAP.put("smallint", "Integer" );
        NUM_MAP.put("integer", "Integer" );
        NUM_MAP.put("bigint", "Long" );
        NUM_MAP.put("float", "Float" );
        NUM_MAP.put("double", "Double" );
        NUM_MAP.put("decimal", "BigDecimal" );

        OTHER_MAP.put("char", "String" );
        OTHER_MAP.put("varchar", "String" );
        OTHER_MAP.put("tinytext", "String" );
        OTHER_MAP.put("text", "String" );
        OTHER_MAP.put("longtext", "String" );

        OTHER_MAP.put("date", "LocalDateTime" );
        OTHER_MAP.put("datetime", "LocalDateTime" );
        OTHER_MAP.put("timestamp", "LocalDateTime" );
    }

    public static Map<String,String> getTemplateMap(String packagePath,String classname){
        HashMap<String, String> tempMap = new HashMap<>();
        tempMap.put("entity.ftl",packagePath.replace(".", "/" ) + "/bean/" + classname + "Entity.java");
        tempMap.put("mapper.ftl",packagePath.replace(".", "/" ) + "/mapper/" + classname + "Mapper.java");
        tempMap.put("service.ftl",packagePath.replace(".", "/" ) + "/service/" + classname + "Service.java");
        tempMap.put("serviceImpl.ftl",packagePath.replace(".", "/" ) + "/service/impl/" + classname + "ServiceImpl.java");
        tempMap.put("controller.ftl",packagePath.replace(".", "/" ) + "/controller/" + classname + "Controller.java");
        tempMap.put("mapper.xml.ftl",packagePath.replace(".", "/" ) + "/"+classname + "Mapper.xml");
        return tempMap;
    }

    /**
     * 根据sql类型获取对应的Java类型
     * @param sqlType
     * @return
     */
    public static String getJavaType(String sqlType) {
        String javaType = NUM_MAP.get(sqlType);
        if (javaType == null) {
            javaType = OTHER_MAP.get(sqlType);
        }
        return javaType;
    }
}
