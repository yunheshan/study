package com.bcs.study.module.other.generator.service;

import org.springframework.stereotype.Component;

import java.util.HashMap;

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
