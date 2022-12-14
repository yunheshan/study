package com.bcs.study.module.business.admin.service;

import com.bcs.study.common.PageResultDTO;
import com.bcs.study.common.ResponseDTO;
import com.bcs.study.module.business.admin.domain.AdminDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bcs.study.module.business.admin.domain.dto.AdminSaveDTO;
import com.bcs.study.module.business.admin.domain.dto.AdminQueryDTO;
import com.bcs.study.module.business.admin.domain.dto.AdminUpdateDTO;
import com.bcs.study.module.business.admin.domain.vo.AdminVO;

/**
 * @Desc 管理员表 服务类
 * @Data
 * @Author bcs
 * @Version 1.0.0
 */
public interface AdminService extends IService<AdminDO> {

    /**
     * 分页查询
     * @param adminQueryDTO
     * @return
     */
    ResponseDTO<PageResultDTO<AdminVO>> listPageAdmins(AdminQueryDTO adminQueryDTO);

    /**
     * 新增
     * @param adminSaveDTO
     * @return
     */
    ResponseDTO<String> saveAdmin(AdminSaveDTO adminSaveDTO);

    /**
     * 更改
     * @param adminUpdateDTO
     * @return
     */
    ResponseDTO<String> updateAdmin(AdminUpdateDTO adminUpdateDTO);
}