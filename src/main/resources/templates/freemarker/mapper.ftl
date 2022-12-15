<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.bcs.study.module.${packageName}.dao.${className}Dao">
    <resultMap id="${className}VO" type="com.bcs.study.module.${packageName}.domain.vo.${className}VO"/>

    <sql id="allColumns">
        <#list oriColumns as column>
            ${alias}.`column.columnName`,
        </#list>
    </sql>

    <update id="removeBatch${className}">
        update ${tableName} ${alias} set is_deleted = 1 where id in
        <foreach collection="list" open="(" close=")" separator="," item="id" >
            #{id}
        </foreach>
    </update>

    <delete id="deleteBatch${className}">
        delete from ${tableName} ${alias} where id in
        <foreach collection="list" open="(" close=")" separator="," item="id" >
            #{id}
        </foreach>
    </delete>

    <select id="listPage${className}s" resultMap="${className}VO">
        select
        <trim suffixOverrides=",">
            <include refid="allColumns">
                <property name="alias" value="${alias}"/>
            </include>
        </trim>
        from ${tableName} ${alias}
        <where>
            ${alias}.is_deleted = 0
            <if test="adminQueryDTO.createTimeBegin!=null">
                and ${alias}.create_time &gt;= #{adminQueryDTO.createTimeBegin}
            </if>
            <if test="adminQueryDTO.createTimeEnd!=null">
                and ${alias}.create_time &lt;= #{adminQueryDTO.createTimeEnd}
            </if>
            <if test="adminQueryDTO.updateTimeBegin!=null">
                and ${alias}.update_time &gt;= #{adminQueryDTO.updateTimeBegin}
            </if>
            <if test="adminQueryDTO.updateTimeEnd!=null">
                and ${alias}.update_time &lt;= #{adminQueryDTO.updateTimeEnd}
            </if>
        </where>
        order by ${alias}.update_time desc
    </select>

    <select id="selectById" resultMap="${className}VO">
        select
        <trim suffixOverrides=",">
            <include refid="allColumns">
                <property name="alias" value="${alias}"/>
            </include>
        </trim>
        from ${tableName} ${alias}
        <where>
            ${alias}.is_deleted = 0
            and ${alias}.id = #{id}
        </where>
    </select>
</mapper>