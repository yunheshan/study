package com.bcs.study.module.business.admin.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bcs.study.module.business.admin.domain.AdminDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bcs.study.module.business.admin.domain.dto.AdminQueryDTO;
import com.bcs.study.module.business.admin.domain.vo.AdminVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Desc 管理员表 Mapper 接口
 * @Data
 * @Author bcs
 * @Version 1.0.0
 */
@Mapper
public interface AdminDao extends BaseMapper<AdminDO> {

    IPage<AdminVO> queryByPage(Page<AdminVO> page, AdminQueryDTO adminQueryDTO);
}